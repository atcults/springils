package org.sanelib.ils.api.converters.author;


import org.junit.Test;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.UpdateAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateAuthorConverterTest {

    @Test
    public void testUpdateAuthorSuccessExecute() throws Exception{
        AuthorDto dto = new AuthorDto();

        dto.setCode("1");
        dto.setLastName("Author Last Name");
        dto.setFirstName("Author First Name");
        dto.setPhone("+91-9876543219");
        dto.setAddress("Address");
        dto.setCity("city");
        dto.setState("ST");
        dto.setZipCode("54321");
        dto.setContract("true");

        ProcessError processError = new ProcessError();

        UpdateAuthorConverter updateAuthorConverter = new UpdateAuthorConverter();
        ProcessCommand command = updateAuthorConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateAuthor);

        UpdateAuthor updateAuthor = (UpdateAuthor) command;

        assertEquals("Code is not mapped", dto.getCode(), updateAuthor.getCode());
        assertEquals("Last name is not mapped", dto.getLastName(), updateAuthor.getLastName());
        assertEquals("First name is not mapped", dto.getFirstName(), updateAuthor.getFirstName());
        assertEquals("Phone number is not mapped", dto.getPhone(), StringHelper.toOriginalString(updateAuthor.getPhone()));
        assertEquals("Address is not mapped", dto.getAddress(), updateAuthor.getAddress());
        assertEquals("City is not mapped", dto.getCity(), updateAuthor.getCity());
        assertEquals("State is not mapped", dto.getState(), updateAuthor.getState());
        assertEquals("Zip code is not mapped", dto.getZipCode(), updateAuthor.getZipCode());
        assertEquals("Contract is not mapped", Boolean.parseBoolean(dto.getContract()), updateAuthor.isContract());

    }

}
