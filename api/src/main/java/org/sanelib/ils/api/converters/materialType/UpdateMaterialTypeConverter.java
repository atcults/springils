package org.sanelib.ils.api.converters.materialType;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.commands.materialType.UpdateMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateMaterialTypeConverter extends AddMaterialTypeConverter {

    @Override
    public ProcessCommand convert(MaterialTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddMaterialType addMaterialType = (AddMaterialType) super.convert(dto, processError);

        UpdateMaterialType updateMaterialType = new UpdateMaterialType();
        ReflectionHelper.copy(addMaterialType, updateMaterialType);

        ConverterHelper.checkIdRequired(dto, updateMaterialType, processError);

        return updateMaterialType;
    }

}
