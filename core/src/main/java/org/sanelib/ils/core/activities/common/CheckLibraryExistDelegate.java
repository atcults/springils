package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckLibraryExistDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckLibraryExistDelegate.class);

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking existing library");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer libraryId = ((ProcessCommandWithLibraryId) command).getLibraryId();

        Library library = this.unitOfWork.getEntityManager().find(Library.class, libraryId);

        if(library == null){
            processError.addError("common.field.notExist", "libraryId", Arrays.asList("domain.entity.library", "domain.common.libraryId"), String.valueOf(libraryId));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
