package org.sanelib.ils.api.converters.holiday;

import org.junit.Test;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.holiday.DeleteHoliday;
import org.sanelib.ils.core.enums.HolidayType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteHolidayConverterTest {

    @Test
    public void testDeleteHolidaySuccessExecute() throws Exception{

        HolidayDto dto = new HolidayDto();

        dto.setLibraryId("2");
        dto.setFiscalYearId("20152016");
        dto.setStartDate("2016/02/09");
        dto.setEndDate("2016/02/11");
        dto.setHolidayType("Specific");

        ProcessError processError = new ProcessError();

        DeleteHolidayConverter converter = new DeleteHolidayConverter();
        ProcessCommand command = converter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteHoliday);

        DeleteHoliday deleteHoliday = (DeleteHoliday) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteHoliday.getLibraryId()));
        assertEquals("FiscalYear Id is not mapped", dto.getFiscalYearId(), String.valueOf(deleteHoliday.getFiscalYearId()));
        assertEquals("Start Date is not mapped ", DateHelper.fromDateString(dto.getStartDate()), deleteHoliday.getStartDate());
        assertEquals("End Date is not mapped ", DateHelper.fromDateString(dto.getEndDate()), deleteHoliday.getEndDate());
        assertEquals("Holiday Type is not mapped ", HolidayType.Specific, deleteHoliday.getHolidayType());
    }
}
