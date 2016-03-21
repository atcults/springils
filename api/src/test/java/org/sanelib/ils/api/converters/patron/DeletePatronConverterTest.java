package org.sanelib.ils.api.converters.patron;


import org.junit.Test;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.DeletePatron;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class DeletePatronConverterTest  {

    @Test
    public void testDeletePatronSuccessExecute() throws Exception {

        PatronDto dto = new PatronDto();

        dto.setLibraryId("1");
        dto.setCode("Pat1");

        ProcessError processError= new ProcessError();

        DeletePatronConverter converter = new DeletePatronConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeletePatron);

        DeletePatron deletePatron = (DeletePatron) command;

        assertEquals("Code is not mapped", dto.getCode(), deletePatron.getCode());
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deletePatron.getLibraryId()));
    }
}
