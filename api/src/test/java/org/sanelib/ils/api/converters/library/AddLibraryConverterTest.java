package org.sanelib.ils.api.converters.library;

import org.junit.Test;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddLibraryConverterTest {

    @Test
    public void testAddLibrarySuccessExecute() throws Exception{
        LibraryDto dto = new LibraryDto();

        dto.setId("1");
        dto.setName("Library");
        dto.setCity("City");
        dto.setState("State");
        dto.setCountry("Country");

        ProcessError processError = new ProcessError();

        AddLibraryConverter addLibraryConverter = new AddLibraryConverter();
        ProcessCommand command = addLibraryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddLibrary);

        AddLibrary addLibrary = (AddLibrary) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(addLibrary.getId()));
        assertEquals("Name is not mapped", dto.getName(), addLibrary.getName());
        assertEquals("City is not mapped", dto.getCity(), addLibrary.getCity());
        assertEquals("State is not mapped", dto.getState(), addLibrary.getState());
        assertEquals("Country is not mapped", dto.getCountry(), addLibrary.getCountry());
    }
}
