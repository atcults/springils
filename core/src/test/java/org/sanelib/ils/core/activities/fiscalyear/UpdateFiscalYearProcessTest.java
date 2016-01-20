package org.sanelib.ils.core.activities.fiscalyear;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class UpdateFiscalYearProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateFiscalYearProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        FiscalYear fiscalYear = new FiscalYear();

        fiscalYear.setFiscalYearId(hibernateHelper.getNextId(FiscalYear.class, "fiscalYearId.id"), library.getId());

        fiscalYear.setFirstFiscalYear(2015);
        fiscalYear.setSecondFiscalYear(2016);
        fiscalYear.setStartDate(DateHelper.constructDate(2015 , 4 ,1));
        fiscalYear.setEndDate(DateHelper.constructDate(2016 , 3 , 31));
        fiscalYear.setStatus("");
        fiscalYear.setEntryId("john");
        fiscalYear.setEntryDate(DateHelper.constructDate(2015 , 4 ,1));

        persist(fiscalYear);

        Date startDate = DateHelper.constructDate(2015, 4, 1);
        Date endDate = DateHelper.constructDate(2016, 3 ,31);
        Date entryDate = DateHelper.constructDate(2015, 4 ,1);

        UpdateFiscalYear updateFiscalYear = new UpdateFiscalYear();

        updateFiscalYear.setId(fiscalYear.getFiscalYearId().getId());
        updateFiscalYear.setLibraryId(library.getId());
        updateFiscalYear.setFirstFiscalYear(2015);
        updateFiscalYear.setSecondFiscalYear(2016);
        updateFiscalYear.setStartDate(startDate);
        updateFiscalYear.setEndDate(endDate);
        updateFiscalYear.setStatus("");
        updateFiscalYear.setEntryId("johny");
        updateFiscalYear.setEntryDate(entryDate);

        String result = execute(updateFiscalYear, ActivitiProcessConstants.Admin.UPDATE_FISCALYEAR);

        assertNull(result);

        FiscalYear dbFiscalYear = fetch(FiscalYear.class, new FiscalYearId(library.getId(), fiscalYear.getFiscalYearId().getId()));

        assertNotNull(dbFiscalYear);

        assertEquals(Integer.valueOf("2015"),updateFiscalYear.getFirstFiscalYear());
        assertEquals(Integer.valueOf("2016"),updateFiscalYear.getSecondFiscalYear());
        assertEquals(startDate, fiscalYear.getStartDate());
        assertEquals(endDate,fiscalYear.getEndDate());
        assertEquals("",updateFiscalYear.getStatus());
        assertEquals("johny",updateFiscalYear.getEntryId());
        assertEquals(entryDate,fiscalYear.getEntryDate());

    }
}
