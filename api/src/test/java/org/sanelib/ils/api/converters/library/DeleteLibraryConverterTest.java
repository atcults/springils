package org.sanelib.ils.api.converters.library;


import org.junit.Test;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.DeleteLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteLibraryConverterTest {

    @Test
    public void testDeleteLibrarySuccessExecute() throws Exception{

        LibraryDto dto = new LibraryDto();

        dto.setId("1");

        ProcessError processError= new ProcessError();

        DeleteLibraryConverter deleteLibraryConverter = new DeleteLibraryConverter();
        ProcessCommand command = deleteLibraryConverter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteLibrary);

        DeleteLibrary deleteLibrary = (DeleteLibrary) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteLibrary.getId()));
    }

}
