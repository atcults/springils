package org.sanelib.ils.api.converters.publisher;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.DeletePublisher;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeletePublisherConverter implements DtoToCommandConverter<PublisherDto> {
    public ProcessCommand convert(PublisherDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeletePublisher command = new DeletePublisher();

        ConverterHelper.checkCodeRequired(dto, command, processError);

       return command;
    }
}
