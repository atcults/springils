package org.sanelib.ils.api.converters.agency;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.DeleteAgency;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteAgencyConverter implements DtoToCommandConverter<AgencyDto> {
    public ProcessCommand convert(AgencyDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteAgency command = new DeleteAgency();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        return command;
    }
}
