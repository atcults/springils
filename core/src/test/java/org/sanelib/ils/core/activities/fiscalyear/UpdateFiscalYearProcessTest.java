package org.sanelib.ils.core.activities.fiscalyear;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
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
        fiscalYear.setLibraryId(library.getId());
        fiscalYear.setStartDate(DateHelper.constructDate(2015 , 4 ,1));
        fiscalYear.setEndDate(DateHelper.constructDate(2016 , 3 , 31));
        fiscalYear.setEntryId("john");

        persist(fiscalYear);

        Date startDate = DateHelper.constructDate(2015, 4, 1);
        Date endDate = DateHelper.constructDate(2016, 3 ,31);

        UpdateFiscalYear updateFiscalYear = new UpdateFiscalYear();

        updateFiscalYear.setId(fiscalYear.getFiscalYearId().getId());
        updateFiscalYear.setLibraryId(library.getId());
        updateFiscalYear.setStartDate(startDate);
        updateFiscalYear.setEndDate(endDate);
        updateFiscalYear.setEntryId("johny");

        String result = execute(updateFiscalYear, ActivitiProcessConstants.Admin.UPDATE_FISCALYEAR);

        assertNull(result);

        FiscalYear dbFiscalYear = fetch(FiscalYear.class, new FiscalYearId(library.getId(), fiscalYear.getFiscalYearId().getId()));

        assertNotNull(dbFiscalYear);

        assertEquals(startDate, fiscalYear.getStartDate());
        assertEquals(endDate,fiscalYear.getEndDate());
        assertEquals("johny",updateFiscalYear.getEntryId());
    }
}
