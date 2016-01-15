package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckEntityExistsWithCodeDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking id for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithCode)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        String code = ((ProcessCommandWithCode) command).getCode();

        if(this.unitOfWork.getCurrentSession().get(((ProcessCommandWithCode) command).getRootEntityClass(), code) == null){
            processError.addError("common.field.notexist", "code", "domain.common.code", code);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
