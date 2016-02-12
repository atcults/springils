package org.sanelib.ils.api.converters.holiday;

import org.junit.Test;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.enums.HolidayType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddHolidayConverterTest {

    @Test
    public void testAddHolidaySuccessExecute() throws Exception{

        HolidayDto dto = new HolidayDto();

        dto.setLibraryId("1");
        dto.setFiscalYearId("20152016");
        dto.setStartDate("2016/02/12");
        dto.setEndDate("2016/02/29");
        dto.setHolidayType(HolidayType.getByName("Specific"));

        ProcessError processError = new ProcessError();

        AddHolidayConverter addHolidayConverter = new AddHolidayConverter();
        ProcessCommand command = addHolidayConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddHoliday);

        AddHoliday addHoliday = (AddHoliday) command;

        assertEquals("Library Id is not mapped ", Integer.valueOf(dto.getLibraryId()), addHoliday.getLibraryId());
        assertEquals("Start Date is not mapped ", DateHelper.fromDateString(dto.getStartDate()), addHoliday.getStartDate());
        assertEquals("End Date is not mapped ", dto.getEndDate(), DateHelper.toDateString(addHoliday.getEndDate()));
        assertEquals("Holiday type is not mapped ", dto.getHolidayType(), addHoliday.getHolidayType());
    }
}
