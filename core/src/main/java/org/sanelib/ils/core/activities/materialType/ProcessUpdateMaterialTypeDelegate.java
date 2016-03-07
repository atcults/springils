package org.sanelib.ils.core.activities.materialType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.materialType.UpdateMaterialType;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateMaterialTypeDelegate implements JavaDelegate{

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateMaterialTypeDelegate.class);

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process Update Material Type called");

        UpdateMaterialType command = (UpdateMaterialType) execution.getVariable("command");

        MaterialType entity = materialTypeRepository.get(command.getId());

        entity.setMaterialType(command.getMaterialType());

        materialTypeRepository.save(entity);


    }
}
