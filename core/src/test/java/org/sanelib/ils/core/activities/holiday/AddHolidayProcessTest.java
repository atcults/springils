package org.sanelib.ils.core.activities.holiday;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.HolidayRepository;
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

    @Test
    public void testAddHolidayProcess() throws Throwable{

        Library library = new Library();

        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");
        library.setCity("City");
        library.setState("State");
        library.setCountry("Country");

        persist(library);

        AddHoliday addHoliday = new AddHoliday();

        addHoliday.setStartDate(DateHelper.constructDate(2015 , 2 , 6));
        addHoliday.setEndDate(DateHelper.constructDate(2015 , 2, 9));
        addHoliday.setLibraryId(library.getId());
        addHoliday.setFiscalYearId(20152016);
        addHoliday.setHolidayType(HolidayType.Specific);
        addHoliday.setNote("1");
        addHoliday.setEntryId(1);

        String result = execute(addHoliday , ActivitiProcessConstants.Admin.ADD_HOLIDAY);


        assertNotNull(result);

        Holiday holiday = fetch(Holiday.class , new HolidayId(library.getId() , addHoliday.getStartDate()));

        assertEquals(addHoliday.getFiscalYearId(), holiday.getFiscalYearId());
        assertEquals(addHoliday.getHolidayType(), holiday.getHolidayType());
        assertEquals(addHoliday.getNote(), holiday.getNote());
        assertEquals(addHoliday.getEntryId(), holiday.getEntryId());

    }
}
