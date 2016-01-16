package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckEntityExistsWithIdDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking id for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer id = ((ProcessCommandWithId) command).getId();

        if(this.unitOfWork.getCurrentSession().get(((ProcessCommand) command).getRootEntityClass(), id) == null){
            processError.addError("common.field.notexist", "id", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.common.id"), String.valueOf(id));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
