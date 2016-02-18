package org.sanelib.ils.core.activities.holiday;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.holiday.DeleteHoliday;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.enums.HolidayType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DeleteHolidayProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteHolidayProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        FiscalYear fiscalYear = new FiscalYear();
        fiscalYear.setLibraryId(library.getId());
        fiscalYear.setStartDate(DateHelper.constructDate(2015 , 4 ,1));
        fiscalYear.setEndDate(DateHelper.constructDate(2016 , 3 , 31));
        fiscalYear.setEntryId("1");

        persist(fiscalYear);

        Holiday holiday = new Holiday();

        holiday.setFiscalYearId(20152016);
        holiday.setLibraryId(library.getId());
        holiday.setHolidayDate(DateHelper.constructDate(2016 , 2 , 12));
        holiday.setHolidayType(HolidayType.Specific);
        holiday.setNote("Holiday");
        holiday.setEntryId("1");
        holiday.setEntryLibraryId(1);

        persist(holiday);

        DeleteHoliday deleteHoliday = new DeleteHoliday();

        deleteHoliday.setLibraryId(library.getId());
        deleteHoliday.setFiscalYearId(20152016);
        deleteHoliday.setStartDate(DateHelper.constructDate(2016 , 2 , 11));
        deleteHoliday.setEndDate(DateHelper.constructDate(2016 , 2 , 14));
        deleteHoliday.setHolidayType(HolidayType.Specific);

        String result = execute(deleteHoliday, ActivitiProcessConstants.Admin.DELETE_HOLIDAY);

        assertEquals("1", result);
    }
}
