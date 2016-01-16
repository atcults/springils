package org.sanelib.ils.api.converters.library;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.DeleteLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteLibraryConverter implements DtoToCommandConverter<LibraryDto> {
    public ProcessCommand convert(LibraryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteLibrary command = new DeleteLibrary();

        ConverterHelper.checkIdRequired(dto, command, processError);

       return command;
    }
}
