package org.sanelib.ils.api.converters.fiscalyear;

import org.junit.Test;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UpdateFiscalYearConverterTest {


    @Test
    public void testUpdateFiscalYearSuccessExecute() throws Exception {
        FiscalYearDto dto = new FiscalYearDto();

        dto.setId("12345");
        dto.setLibraryId("101");
        dto.setFirstFiscalYear("2015");
        dto.setSecondFiscalYear("2016");
        dto.setStartDate("2015/04/01");
        dto.setEndDate("2016/03/31");
        dto.setStatus("");
        dto.setEntryId("john");
        dto.setEntryDate("2015/04/01");

        ProcessError processError = new ProcessError();

        UpdateFiscalYearConverter updateFiscalYearConverter = new UpdateFiscalYearConverter();
        ProcessCommand command = updateFiscalYearConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateFiscalYear);

        UpdateFiscalYear updateFiscalYear = (UpdateFiscalYear) command;

        assertEquals("Library Id is not mapped ", Integer.valueOf(dto.getLibraryId()), updateFiscalYear.getLibraryId());
        assertEquals("Fiscal Year is not mapped ", Integer.valueOf(dto.getId()), updateFiscalYear.getId());
        assertEquals("First Fiscal Year is not mapped ", Integer.valueOf(dto.getFirstFiscalYear()), updateFiscalYear.getFirstFiscalYear());
        assertEquals("Second Fiscal Year is not mapped ", Integer.valueOf(dto.getSecondFiscalYear()), updateFiscalYear.getSecondFiscalYear());
        assertEquals("Start Date is not mapped ", dto.getStartDate(), DateHelper.toDateString(updateFiscalYear.getStartDate()));
        assertEquals("End Date is not mapped ", dto.getEndDate(), DateHelper.toDateString(updateFiscalYear.getEndDate()));
        assertEquals("Status is not mapped ", dto.getStatus(), updateFiscalYear.getStatus());
        assertEquals("Entry Id is not mapped ", dto.getEntryId(), updateFiscalYear.getEntryId());
        assertEquals("Entry Date is not mapped ", dto.getEntryDate(), DateHelper.toDateString(updateFiscalYear.getEntryDate()));
    }
}
