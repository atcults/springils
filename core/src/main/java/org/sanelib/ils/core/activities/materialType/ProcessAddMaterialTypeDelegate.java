package org.sanelib.ils.core.activities.materialType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddMaterialTypeDelegate implements JavaDelegate{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Add Material Type called");

        AddMaterialType command= (AddMaterialType) execution.getVariable("command");

        MaterialType entity = new MaterialType();

        entity.setId(hibernateHelper.getNextId(MaterialType.class));
        entity.setMaterialType(command.getMaterialType());

        materialTypeRepository.save(entity);

        execution.setVariable("result", entity.getId());
    }

}
