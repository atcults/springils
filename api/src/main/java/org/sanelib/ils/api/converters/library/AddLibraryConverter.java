package org.sanelib.ils.api.converters.library;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddLibraryConverter implements DtoToCommandConverter<LibraryDto> {

    @Override
    public ProcessCommand convert(LibraryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddLibrary command = new AddLibrary();

        //Check name and convert
        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.library.name");
        } else{
            command.setName(dto.getName());
        }

        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());

        return command;
    }
}
