package org.sanelib.ils.api.converters.agency;

import org.junit.Test;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.DeleteAgency;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteAgencyConverterTest {

    @Test
    public void testDeleteAgencySuccessExecute() throws Exception{

        AgencyDto dto = new AgencyDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteAgencyConverter converter = new DeleteAgencyConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteAgency);

        DeleteAgency deleteAgency = (DeleteAgency) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteAgency.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteAgency.getLibraryId()));
    }

}
