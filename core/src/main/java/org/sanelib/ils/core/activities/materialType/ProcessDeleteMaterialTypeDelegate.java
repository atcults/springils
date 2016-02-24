package org.sanelib.ils.core.activities.materialType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.materialType.DeleteMaterialType;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteMaterialTypeDelegate implements JavaDelegate{

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        DeleteMaterialType command = (DeleteMaterialType) execution.getVariable("command");
        MaterialType materialType = this.materialTypeRepository.load(command.getId());

        materialTypeRepository.remove(materialType);
    }
}
