package org.sanelib.ils.api.converters.publisher;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddPublisherConverter implements DtoToCommandConverter<PublisherDto> {

    @Override
    public ProcessCommand convert(PublisherDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddPublisher command = new AddPublisher();

        ConverterHelper.checkCodeRequired(dto, command, processError);

        //Check name and convert
        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.publisher.name");
        }else{
            command.setName(dto.getName());
        }

        command.setCity(dto.getCity());

        //Check State should not more than 2 characters
        if(ConverterHelper.checkRequiredLength(dto.getState(), 2, "state", "domain.publisher.state", processError)){
            command.setState(dto.getState());
        }

        command.setCountry(dto.getCountry());

        return command;
    }
}
