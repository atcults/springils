package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckEntityExistsWithCodeDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckEntityExistsWithCodeDelegate.class);

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking code for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithCode)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        String code = ((ProcessCommandWithCode) command).getCode();

        if(this.unitOfWork.getCurrentSession().get(((ProcessCommand) command).getRootEntityClass(), code) == null){
            processError.addError("common.field.notExist", "code", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.common.code"), code);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
