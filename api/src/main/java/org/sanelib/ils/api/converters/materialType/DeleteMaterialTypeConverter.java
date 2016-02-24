package org.sanelib.ils.api.converters.materialType;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.DeleteMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteMaterialTypeConverter implements DtoToCommandConverter<MaterialTypeDto> {

    @Override
    public ProcessCommand convert(MaterialTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteMaterialType command = new DeleteMaterialType();

        ConverterHelper.checkIdRequired(dto, command, processError);

        return command;
    }
}
