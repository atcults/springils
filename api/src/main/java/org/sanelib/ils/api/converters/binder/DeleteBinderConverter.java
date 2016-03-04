package org.sanelib.ils.api.converters.binder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.DeleteBinder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteBinderConverter implements DtoToCommandConverter<BinderDto> {
    public ProcessCommand convert(BinderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteBinder command = new DeleteBinder();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

       return command;
    }
}
