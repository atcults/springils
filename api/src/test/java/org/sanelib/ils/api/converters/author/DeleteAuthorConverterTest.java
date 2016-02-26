package org.sanelib.ils.api.converters.author;

import org.junit.Test;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.DeleteAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteAuthorConverterTest {

    @Test
    public void testDeleteAuthorSuccessExecute() throws Exception{

        AuthorDto authorDto = new AuthorDto();

        authorDto.setCode("1");

        ProcessError processError= new ProcessError();

        DeleteAuthorConverter deleteAuthorConverter = new DeleteAuthorConverter();
        ProcessCommand command = deleteAuthorConverter.convert(authorDto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteAuthor);

        DeleteAuthor deleteAuthor = (DeleteAuthor) command;

        assertEquals("Code is not mapped", authorDto.getCode(), deleteAuthor.getCode());
    }

}
