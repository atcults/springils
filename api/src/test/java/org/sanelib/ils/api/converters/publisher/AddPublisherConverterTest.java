package org.sanelib.ils.api.converters.publisher;

import org.junit.Test;
import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddPublisherConverterTest {

    @Test
    public void testAddPublisherSuccessExecute() throws Exception{
        PublisherDto dto = new PublisherDto();

        dto.setCode("PUBS");
        dto.setName("Publisher");
        dto.setCity("City");
        dto.setState("State");
        dto.setCountry("Country");


        ProcessError processError = new ProcessError();

        AddPublisherConverter addPublisherConverter = new AddPublisherConverter();
        ProcessCommand command = addPublisherConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddPublisher);
        AddPublisher addPublisher = (AddPublisher) command;
        assertEquals("Code is not mapped", dto.getCode(), addPublisher.getCode());
        assertEquals("Name is not mapped", dto.getName(), addPublisher.getName());
        assertEquals("City is not mapped", dto.getCity(), addPublisher.getCity());
        assertEquals("State is not mapped", dto.getState(), addPublisher.getState());
        assertEquals("Country is not mapped", dto.getCountry(), addPublisher.getCountry());
    }
}
