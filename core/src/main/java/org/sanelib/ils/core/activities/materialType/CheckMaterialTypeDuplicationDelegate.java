package org.sanelib.ils.core.activities.materialType;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckMaterialTypeDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckMaterialTypeDuplicationDelegate.class);

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking Material type for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        String materialType = ((AddMaterialType) command).getMaterialType();

        List<MaterialType> materialTypes = materialTypeRepository.findByColumnAndValue("materialType", materialType);

        MaterialType dbMaterialType = materialTypes.isEmpty() ? null : materialTypes.get(0);

        if(dbMaterialType != null){
            processError.addError("common.field.duplicate", "materialType", Arrays.asList("domain.entity.materialType", "domain.common.name"), materialType);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }

}

