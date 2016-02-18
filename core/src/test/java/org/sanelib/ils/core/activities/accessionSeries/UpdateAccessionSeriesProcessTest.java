package org.sanelib.ils.core.activities.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.accessioSeries.UpdateAccessionSeries;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.domain.entity.AccessionSeriesCode;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UpdateAccessionSeriesProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateAccessionSeriesProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        AccessionSeries accessionSeries = new AccessionSeries();

        accessionSeries.setAccessionSeriesCode("AS1", library.getId());
        accessionSeries.setMaxNumber(100);
        accessionSeries.setMaxZero(2);
        accessionSeries.setPrefix("AS");
        accessionSeries.setTypeName(AccessionSeriesType.Fixed);
        accessionSeries.setEntryId("1");
        accessionSeries.setEntryDate(DateHelper.fromDateString("2016-01-01"));

        persist(accessionSeries);

        UpdateAccessionSeries updateAccessionSeries = new UpdateAccessionSeries();

        updateAccessionSeries.setCode(accessionSeries.getAccessionSeriesCode().getCode());
        updateAccessionSeries.setLibraryId(library.getId());
        updateAccessionSeries.setMaxNumber(100);
        updateAccessionSeries.setMaxZero(2);
        updateAccessionSeries.setPrefix("AS");
        updateAccessionSeries.setTypeName(AccessionSeriesType.Fixed);
        updateAccessionSeries.setEntryId("1");
        updateAccessionSeries.setEntryDate(DateHelper.fromDateString("2016-01-01"));

        String result = execute(updateAccessionSeries, ActivitiProcessConstants.Admin.UPDATE_ACCESSIONSERIES);

        assertNull(result);

        AccessionSeries dbAccessionSeries = fetch(AccessionSeries.class, new AccessionSeriesCode(library.getId(), accessionSeries.getAccessionSeriesCode().getCode()));

        assertNotNull(dbAccessionSeries);

        assertEquals(updateAccessionSeries.getCode() , accessionSeries.getAccessionSeriesCode().getCode());
        assertEquals(updateAccessionSeries.getMaxNumber() ,accessionSeries.getMaxNumber());
        assertEquals(updateAccessionSeries.getMaxZero() ,accessionSeries.getMaxZero());
        assertEquals(updateAccessionSeries.getPrefix() ,accessionSeries.getPrefix());
        assertEquals(updateAccessionSeries.getTypeName() ,accessionSeries.getTypeName());
        assertEquals(updateAccessionSeries.getEntryId() ,accessionSeries.getEntryId());
        assertEquals(updateAccessionSeries.getEntryDate() ,accessionSeries.getEntryDate());
    }
}
