package org.sanelib.ils.api.converters.agency;


import org.junit.Test;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateAgencyConverterTest {

    @Test
    public void testUpdateAgencySuccessExecute() throws Exception{
        AgencyDto dto = new AgencyDto();
        dto.setId("1");
        dto.setLibraryId("1");
        dto.setName("Agency");

        ProcessError processError = new ProcessError();

        UpdateAgencyConverter updateAgencyConverter = new UpdateAgencyConverter();
        ProcessCommand command = updateAgencyConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateAgency);
        UpdateAgency updateAgency = (UpdateAgency) command;
        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateAgency.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateAgency.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), updateAgency.getName());
    }

}
