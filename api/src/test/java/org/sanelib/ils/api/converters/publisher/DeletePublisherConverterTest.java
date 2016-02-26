package org.sanelib.ils.api.converters.publisher;

import org.junit.Test;
import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.publisher.DeletePublisher;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeletePublisherConverterTest {

    @Test
    public void testDeletePublisherSuccessExecute() throws Exception{

        PublisherDto publisherDto = new PublisherDto();

        publisherDto.setCode("1");

        ProcessError processError = new ProcessError();

        DeletePublisherConverter deletePublisherConverter = new DeletePublisherConverter();
        ProcessCommand command = deletePublisherConverter.convert(publisherDto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeletePublisher);

        DeletePublisher deletePublisher = (DeletePublisher) command;

        assertEquals("Code is not mapped", publisherDto.getCode(), deletePublisher.getCode());
    }

}
