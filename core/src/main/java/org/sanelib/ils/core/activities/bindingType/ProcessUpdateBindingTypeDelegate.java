package org.sanelib.ils.core.activities.bindingType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.dao.BindingTypeRepository;
import org.sanelib.ils.core.domain.entity.BindingType;
import org.sanelib.ils.core.domain.entity.BindingTypeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateBindingTypeDelegate implements JavaDelegate {

    @Autowired
    BindingTypeRepository bindingTypeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update Binding Type called");

        UpdateBindingType command = (UpdateBindingType) execution.getVariable("command");

        BindingType entity = bindingTypeRepository.get(new BindingTypeId(command.getLibraryId(), command.getId()));

        entity.setBindType(command.getBindType());
        entity.setPrice(command.getPrice());
        entity.setEntryId(command.getEntryId());

        bindingTypeRepository.save(entity);
	}
}
