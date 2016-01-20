package org.sanelib.ils.api.converters.fiscalyear;

import org.junit.Test;
import org.sanelib.ils.api.converters.fiscalyear.AddFiscalYearConverter;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.commands.fiscalyear.AddFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddFiscalYearConverterTest {

    @Test
    public void testAddAgencySuccessExecute() throws Exception{

        FiscalYearDto dto = new FiscalYearDto();
        dto.setLibraryId("1");
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

        AddFiscalYearConverter addFiscalYearConverter = new AddFiscalYearConverter();
        ProcessCommand command = addFiscalYearConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddFiscalYear);

        AddFiscalYear addFiscalYear = (AddFiscalYear) command;

        assertEquals("Library Id is not mapped ", Integer.valueOf(dto.getLibraryId()), addFiscalYear.getLibraryId());
        assertEquals("First Fiscal Year is not mapped ", Integer.valueOf(dto.getFirstFiscalYear()), addFiscalYear.getFirstFiscalYear());
        assertEquals("Second Fiscal Year is not mapped ", Integer.valueOf(dto.getSecondFiscalYear()), addFiscalYear.getSecondFiscalYear());
        assertEquals("Start Date is not mapped ", dto.getStartDate(), DateHelper.toDateString(addFiscalYear.getStartDate()));
        assertEquals("End Date is not mapped ", dto.getEndDate(), DateHelper.toDateString(addFiscalYear.getEndDate()));
        assertEquals("Status is not mapped ", dto.getStatus(), addFiscalYear.getStatus());
        assertEquals("Entry Id is not mapped ", dto.getEntryId(), addFiscalYear.getEntryId());
        assertEquals("Entry Date is not mapped ", dto.getEntryDate(), DateHelper.toDateString(addFiscalYear.getEntryDate()));
    }
}
