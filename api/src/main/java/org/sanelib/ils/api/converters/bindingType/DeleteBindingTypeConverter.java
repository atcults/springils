package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.DeleteBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteBindingTypeConverter implements DtoToCommandConverter<BindingTypeDto> {
    public ProcessCommand convert(BindingTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteBindingType command = new DeleteBindingType();
        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);
       return command;
    }
}
