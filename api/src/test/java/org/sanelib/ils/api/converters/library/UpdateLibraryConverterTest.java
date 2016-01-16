package org.sanelib.ils.api.converters.library;


import org.junit.Test;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateLibraryConverterTest {

    @Test
    public void testUpdateLibrarySuccessExecute() throws Exception{
        LibraryDto dto = new LibraryDto();
        dto.setId("1");
        dto.setName("Library");
        dto.setCity("City");
        dto.setState("State");
        dto.setCountry("Country");

        ProcessError processError = new ProcessError();

        UpdateLibraryConverter updateLibraryConverter = new UpdateLibraryConverter();
        ProcessCommand command = updateLibraryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateLibrary);
        UpdateLibrary updateLibrary = (UpdateLibrary) command;
        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateLibrary.getId()));
        assertEquals("Name is not mapped", dto.getName(), updateLibrary.getName());
        assertEquals("City is not mapped", dto.getCity(), updateLibrary.getCity());
        assertEquals("State is not mapped", dto.getState(), updateLibrary.getState());
        assertEquals("Country is not mapped", dto.getCountry(), updateLibrary.getCountry());


    }

}
