package org.sanelib.ils.api.converters.publisher;

import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdatePublisherConverter extends AddPublisherConverter {

    @Override
    public ProcessCommand convert(PublisherDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddPublisher addPublisher = (AddPublisher) super.convert(dto, processError);

        UpdatePublisher updatePublisher = new UpdatePublisher();
        ReflectionHelper.copy(addPublisher, updatePublisher);

        return updatePublisher;
    }
}
