package org.sanelib.ils.core.activities.bindingType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.bindingType.DeleteBindingType;
import org.sanelib.ils.core.dao.BindingTypeRepository;
import org.sanelib.ils.core.domain.entity.BindingType;
import org.sanelib.ils.core.domain.entity.BindingTypeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteBindingTypeDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeleteBindingTypeDelegate.class);

    @Autowired
    BindingTypeRepository bindingTypeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Delete Binding Type called");

        DeleteBindingType command = (DeleteBindingType) execution.getVariable("command");
        BindingType bindingType = this.bindingTypeRepository.load(new BindingTypeId(command.getLibraryId(), command.getId()));
        bindingTypeRepository.remove(bindingType);
	}
}
