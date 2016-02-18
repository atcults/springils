package org.sanelib.ils.core.activities.holiday;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.CustomClock;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.HolidayRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.domain.entity.HolidayId;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.enums.HolidayType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddHolidayProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    Clock clock;

    @Test
    public void testAddHolidayProcess() throws Throwable{

        Library library = new Library();

        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");
        library.setCity("City");
        library.setState("State");
        library.setCountry("Country");

        persist(library);

        FiscalYear fiscalYear = new FiscalYear();
        fiscalYear.setLibraryId(library.getId());
        fiscalYear.setStartDate(DateHelper.constructDate(2015 , 4 ,1));
        fiscalYear.setEndDate(DateHelper.constructDate(2016 , 3 , 31));
        fiscalYear.setEntryId("1");

        persist(fiscalYear);

        AddHoliday addHoliday = new AddHoliday();

        //NOTE: Setting today as 1st Feb 2016
        CustomClock customClock = (CustomClock) clock;
        customClock.set(DateHelper.constructDate(2016, 1, 1));

        addHoliday.setLibraryId(library.getId());
        addHoliday.setFiscalYearId(20152016);
        addHoliday.setHolidayType(HolidayType.Specific);
        addHoliday.setStartDate(DateHelper.constructDate(2016 , 2 , 6));
        addHoliday.setEndDate(DateHelper.constructDate(2016 , 2, 9));
        addHoliday.setNote("Test Holiday");
        addHoliday.setEntryId("1");
        addHoliday.setEntryLibraryId(1);

        String result = execute(addHoliday , ActivitiProcessConstants.Admin.ADD_HOLIDAY);

        //4 Records should be added
        assertEquals("4", result);
    }
}
