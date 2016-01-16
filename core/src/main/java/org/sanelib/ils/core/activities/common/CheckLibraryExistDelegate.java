package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckLibraryExistDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking existing library");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer libraryId = ((ProcessCommandWithLibraryId) command).getLibraryId();

        if(this.unitOfWork.getCurrentSession().get(Library.class, libraryId) == null){
            processError.addError("common.field.notexist", "id", Arrays.asList("domain.entity.library", "domain.common.id"), String.valueOf(libraryId));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
