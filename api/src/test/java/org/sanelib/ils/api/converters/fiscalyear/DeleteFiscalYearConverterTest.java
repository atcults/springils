package org.sanelib.ils.api.converters.fiscalyear;


import org.junit.Test;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalyear.DeleteFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteFiscalYearConverterTest {

    @Test
    public void testDeleteFiscalYearSuccessExecute() throws Exception{

        FiscalYearDto dto = new FiscalYearDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteFiscalYearConverter converter = new DeleteFiscalYearConverter();
        ProcessCommand command = converter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteFiscalYear);

        DeleteFiscalYear deleteFiscalYear = (DeleteFiscalYear) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteFiscalYear.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteFiscalYear.getLibraryId()));
    }

}
