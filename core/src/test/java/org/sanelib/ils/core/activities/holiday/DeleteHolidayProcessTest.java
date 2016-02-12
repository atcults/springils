package org.sanelib.ils.core.activities.holiday;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.holiday.DeleteHoliday;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.domain.entity.HolidayId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteHolidayProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteHolidayProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Holiday holiday = new Holiday();

        holiday.setFiscalYearId(20152016);
        holiday.setHolidayId(DateHelper.constructDate(2016 , 2 , 12) , library.getId());

        persist(holiday);

        DeleteHoliday deleteHoliday = new DeleteHoliday();

        deleteHoliday.setLibraryId(library.getId());
        deleteHoliday.setFiscalYearId(20152016);
        deleteHoliday.setStartDate(DateHelper.constructDate(2016 , 2 , 11));
        deleteHoliday.setEndDate(DateHelper.constructDate(2016 , 2 , 14));

        String result = execute(deleteHoliday, ActivitiProcessConstants.Admin.DELETE_HOLIDAY);

        assertNull(result);

        Holiday dbHoliday = fetch(Holiday.class , new HolidayId(library.getId() , deleteHoliday.getEndDate()));

        assertNull(dbHoliday);
    }
}
