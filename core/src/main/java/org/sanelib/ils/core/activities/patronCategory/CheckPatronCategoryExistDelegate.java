package org.sanelib.ils.core.activities.patronCategory;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckPatronCategoryExistDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking patron category with id and library id");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer id = ((ProcessCommandWithId) command).getId();
        Integer libraryId = ((ProcessCommandWithLibraryId) command).getLibraryId();

        Criteria criteria = unitOfWork.getCurrentSession().createCriteria(((ProcessCommand) command).getRootEntityClass());
        criteria.add(Restrictions.eq("patronCategoryId.id", id));
        criteria.add(Restrictions.eq("patronCategoryId.libraryId", libraryId));

        List list = criteria.list();

        if(list.isEmpty()){
            processError.addError("common.field.notexist", "id", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.common.id"), String.valueOf(id));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
