package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.domain.entity.CirculationMatrixId;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckCirculationMatrixExistDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckCirculationMatrixExistDelegate.class);

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Checking circulation matrix with existing data");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithLibraryId)) {
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        if(!(command instanceof AddCirculationMatrix)) {
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        AddCirculationMatrix circulationMatrixCommand = (AddCirculationMatrix) command;

        Integer libraryId = circulationMatrixCommand.getLibraryId();
        CirculationMatrixId circulationMatrixId = new CirculationMatrixId(circulationMatrixCommand.getLibraryId(), circulationMatrixCommand.getPatronCategoryId() , circulationMatrixCommand.getMaterialTypeId() , circulationMatrixCommand.getWithEffectFrom());

        Criteria criteria = unitOfWork.getCurrentSession().createCriteria(((ProcessCommand) command).getRootEntityClass());

        criteria.add(Restrictions.eq("circulationMatrixId.libraryId", libraryId));
        criteria.add(Restrictions.eq("circulationMatrixId.circulationMatrixId", circulationMatrixId));

        List list = criteria.list();

        if(list.isEmpty()) {
            processError.addError("common.field.notExist" , "libraryId" , Arrays.asList(((ProcessCommand) command).getRootEntityName() , "domain.common.libraryId") , String.valueOf(libraryId));
        }

        if(!processError.isValid()) {
            throw new AppException(processError);
        }
    }
}
