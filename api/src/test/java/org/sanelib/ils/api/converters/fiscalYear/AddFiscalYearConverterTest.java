package org.sanelib.ils.api.converters.fiscalYear;

import org.junit.Test;
import org.sanelib.ils.api.dto.fiscalYear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalYear.AddFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddFiscalYearConverterTest {

    @Test
    public void testAddFiscalYearSuccessExecute() throws Exception{

        FiscalYearDto dto = new FiscalYearDto();
        dto.setLibraryId("1");
        dto.setStartDate("2015-04-01");
        dto.setEndDate("2016-03-31");

        ProcessError processError = new ProcessError();

        AddFiscalYearConverter addFiscalYearConverter = new AddFiscalYearConverter();
        ProcessCommand command = addFiscalYearConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddFiscalYear);

        AddFiscalYear addFiscalYear = (AddFiscalYear) command;

        assertEquals("Library Id is not mapped ", Integer.valueOf(dto.getLibraryId()), addFiscalYear.getLibraryId());
        assertEquals("Start Date is not mapped ", dto.getStartDate(), DateHelper.toDateString(addFiscalYear.getStartDate()));
        assertEquals("End Date is not mapped ", dto.getEndDate(), DateHelper.toDateString(addFiscalYear.getEndDate()));
    }
}
