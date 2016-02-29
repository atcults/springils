package org.sanelib.ils.api.converters.agency;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddAgencyConverter implements DtoToCommandConverter<AgencyDto> {

    @Override
    public ProcessCommand convert(AgencyDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddAgency command = new AddAgency();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        //Check name and convert
        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.common.name");
        } else{
            command.setName(dto.getName());
        }

        return command;
    }
}
