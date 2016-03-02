package org.sanelib.ils.core.activities.accessionSeries;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckAccessionSeriesExistDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckAccessionSeriesExistDelegate.class);

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking AccessionSeries with code and library id");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithCode)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        String code = ((ProcessCommandWithCode) command).getCode();
        Integer libraryId = ((ProcessCommandWithLibraryId) command).getLibraryId();

        Criteria criteria = unitOfWork.getCurrentSession().createCriteria(((ProcessCommand) command).getRootEntityClass());
        criteria.add(Restrictions.eq("accessionSeriesCode.code", code));
        criteria.add(Restrictions.eq("accessionSeriesCode.libraryId", libraryId));

        List list = criteria.list();

        if(list.isEmpty()){
            processError.addError("common.field.notExist", "code", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.accessionSeries.code"), String.valueOf(code));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
