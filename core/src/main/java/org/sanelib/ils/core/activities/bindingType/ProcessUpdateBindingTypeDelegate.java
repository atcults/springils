package org.sanelib.ils.core.activities.bindingType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.dao.BindingTypeRepository;
import org.sanelib.ils.core.domain.entity.BindingType;
import org.sanelib.ils.core.domain.entity.BindingTypeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateBindingTypeDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateBindingTypeDelegate.class);

    @Autowired
    BindingTypeRepository bindingTypeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Update Binding Type called");

        UpdateBindingType command = (UpdateBindingType) execution.getVariable("command");

        BindingType entity = bindingTypeRepository.get(new BindingTypeId(command.getLibraryId(), command.getId()));

        entity.setBindType(command.getBindType());
        entity.setPrice(command.getPrice());
        entity.setUserCode(command.getUserCode());

        bindingTypeRepository.save(entity);
	}
}
