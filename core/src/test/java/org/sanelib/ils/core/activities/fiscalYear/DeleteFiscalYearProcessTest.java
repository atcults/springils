package org.sanelib.ils.core.activities.fiscalYear;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.fiscalYear.DeleteFiscalYear;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteFiscalYearProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteFiscalYearProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        FiscalYear fiscalYear = new FiscalYear();
        fiscalYear.setLibraryId(library.getId());
        fiscalYear.setStartDate(DateHelper.constructDate(2015, 4, 1));
        fiscalYear.setEndDate(DateHelper.constructDate(2016, 3, 31));

        persist(fiscalYear);

        DeleteFiscalYear deleteFiscalYear = new DeleteFiscalYear();

        deleteFiscalYear.setId(fiscalYear.getFiscalYearId().getId());
        deleteFiscalYear.setLibraryId(library.getId());

        String result = execute(deleteFiscalYear, ActivitiProcessConstants.Admin.DELETE_FISCAL_YEAR);

        assertNull(result);

        FiscalYear dbFiscalYear = fetch(FiscalYear.class, new FiscalYearId(library.getId(), fiscalYear.getFiscalYearId().getId()));

        assertNull(dbFiscalYear);
    }
}
