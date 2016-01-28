package org.sanelib.ils.api.converters.author;

import org.junit.Test;
import org.sanelib.ils.api.dto.author.AuthorDTO;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAuthorConverterTest {

    @Test
    public void testAddAuthorSuccessExecute() throws Exception{
        AuthorDTO dto = new AuthorDTO();

        dto.setCode("1");
        dto.setLastName("Author Last Name");
        dto.setFirstName("Author First Name");
        dto.setPhone("+91-9876543219");
        dto.setAddress("Address");
        dto.setCity("city");
        dto.setState("ST");
        dto.setZipCode("54321");

        ProcessError processError = new ProcessError();

        AddAuthorConverter addAuthorConverter = new AddAuthorConverter();
        ProcessCommand command = addAuthorConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddAuthor);

        AddAuthor addAuthor = (AddAuthor) command;

        assertEquals("Code is not mapped", dto.getCode(), addAuthor.getCode());
        assertEquals("Last name is not mapped", dto.getLastName(), addAuthor.getLastName());
        assertEquals("First name is not mapped", dto.getFirstName(), addAuthor.getFirstName());
        assertEquals("Phone number is not mapped", dto.getPhone(), StringHelper.toOriginalString(addAuthor.getPhone()));
        assertEquals("Address is not mapped", dto.getAddress(), addAuthor.getAddress());
        assertEquals("City is not mapped", dto.getCity(), addAuthor.getCity());
        assertEquals("State is not mapped", dto.getState(), addAuthor.getState());
        assertEquals("Zip code is not mapped" ,dto.getZipCode() , addAuthor.getZipCode());
    }
}
