package org.sanelib.ils.api.converters.agency;

import org.junit.Test;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAgencyConverterTest {

    @Test
    public void testAddAgencySuccessExecute() throws Exception{
        AgencyDto dto = new AgencyDto();

        dto.setLibraryId("1");
        dto.setName("Agency");

        ProcessError processError = new ProcessError();

        AddAgencyConverter addAgencyConverter = new AddAgencyConverter();
        ProcessCommand command = addAgencyConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddAgency);

        AddAgency addAgency = (AddAgency) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addAgency.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), addAgency.getName());
    }
}
