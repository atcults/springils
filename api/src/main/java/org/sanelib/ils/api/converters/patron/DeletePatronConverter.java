package org.sanelib.ils.api.converters.patron;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.DeletePatron;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeletePatronConverter implements DtoToCommandConverter<PatronDto> {

    public ProcessCommand convert(PatronDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeletePatron command = new DeletePatron();
        ConverterHelper.checkCodeRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);
        return command;
    }
}
