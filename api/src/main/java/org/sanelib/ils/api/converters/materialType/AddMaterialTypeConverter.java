package org.sanelib.ils.api.converters.materialType;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddMaterialTypeConverter implements DtoToCommandConverter<MaterialTypeDto>{
    @Override
    public ProcessCommand convert(MaterialTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddMaterialType command = new AddMaterialType();

        if(Strings.isNullOrEmpty(dto.getMaterialType())){
            processError.addError("common.field.required", "materialType", "domain.materialType.materialType");
        }else {
            command.setMaterialType(dto.getMaterialType());
        }

        return command;
    }
}
