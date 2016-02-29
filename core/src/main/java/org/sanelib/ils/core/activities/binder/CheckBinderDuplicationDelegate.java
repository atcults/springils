package org.sanelib.ils.core.activities.binder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.dao.BinderRepository;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckBinderDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckBinderDuplicationDelegate.class);

    @Autowired
    BinderRepository binderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking binder for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateBinder;

        Integer binderId = isUpdate ? ((UpdateBinder) command).getId() : null;
        Integer libraryId = ((AddBinder) command).getLibraryId();
        String binderName = ((AddBinder) command).getName();

        List<Binder> binders = binderRepository.findByColumnAndValue(new String[]{"binderId.libraryId", "name"}, new Object[] {libraryId, binderName});

        Binder dbBinder = binders.isEmpty() ? null : binders.get(0);

        if(dbBinder != null && (!isUpdate || !Objects.equals(binderId, dbBinder.getBinderId().getId()))){
            processError.addError("common.field.duplicate", "binderName", Arrays.asList("domain.entity.library", "domain.common.name"), binderName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
