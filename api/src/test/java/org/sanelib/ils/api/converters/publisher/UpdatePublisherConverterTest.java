package org.sanelib.ils.api.converters.publisher;


import org.junit.Test;
import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdatePublisherConverterTest {

    @Test
    public void testUpdatePublisherSuccessExecute() throws Exception{
        PublisherDto dto = new PublisherDto();
        dto.setCode("PUBS");
        dto.setName("Publisher");
        dto.setCity("City");
        dto.setState("GJ");
        dto.setCountry("Country");

        ProcessError processError = new ProcessError();

        UpdatePublisherConverter updatePublisherConverter = new UpdatePublisherConverter();
        ProcessCommand command = updatePublisherConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdatePublisher);
        UpdatePublisher updatePublisher = (UpdatePublisher) command;
        assertEquals("Code is not mapped", dto.getCode(), updatePublisher.getCode());
        assertEquals("Name is not mapped", dto.getName(), updatePublisher.getName());
        assertEquals("City is not mapped", dto.getCity(), updatePublisher.getCity());
        assertEquals("State is not mapped", dto.getState(), updatePublisher.getState());
        assertEquals("Country is not mapped", dto.getCountry(), updatePublisher.getCountry());


    }

}
