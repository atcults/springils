package org.sanelib.ils.core.activities.bindingType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.dao.BindingTypeRepository;
import org.sanelib.ils.core.domain.entity.BindingType;
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
public class CheckBindingTypeDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckBindingTypeDuplicationDelegate.class);

    @Autowired
    BindingTypeRepository bindingTypeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking bindingType for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateBindingType;

        Integer bindingTypeId = isUpdate ? ((UpdateBindingType) command).getId() : null;
        Integer libraryId = ((AddBindingType) command).getLibraryId();
        String bindingType = ((AddBindingType) command).getBindType();

        List<BindingType> bindingTypes = bindingTypeRepository.findByColumnAndValue(new String[]{"bindingTypeId.libraryId", "bindType"}, new Object[] {libraryId, bindingType});

        BindingType dbBindingType = bindingTypes.isEmpty() ? null : bindingTypes.get(0);

        if(dbBindingType != null && (!isUpdate || !Objects.equals(bindingTypeId, dbBindingType.getBindingTypeId().getId()))){
            processError.addError("common.field.duplicate", "bindType", Arrays.asList("domain.entity.bindingType", "domain.bindingType.bindType"), bindingType);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
