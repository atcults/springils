package org.sanelib.ils.core.activities.fiscalyear;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.fiscalyear.AddFiscalYear;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddFiscalYearProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;


    @Test
    public void testAddFiscalYearProcess() throws Throwable {

        Library library = new Library();

        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("name");
        library.setCity("City");
        library.setState("State");
        library.setCountry("Country");

        persist(library);

        AddFiscalYear addFiscalYear = new AddFiscalYear();

        addFiscalYear.setLibraryId(library.getId());
        addFiscalYear.setFirstFiscalYear(2015);
        addFiscalYear.setSecondFiscalYear(2016);
        addFiscalYear.setStartDate(DateHelper.constructDate(2015 , 4 ,1));
        addFiscalYear.setEndDate(DateHelper.constructDate(2016 , 3 , 31));
        addFiscalYear.setStatus("a");
        addFiscalYear.setEntryId("john");
        addFiscalYear.setEntryDate(DateHelper.constructDate(2015 , 4 ,1));

        String result = execute(addFiscalYear, ActivitiProcessConstants.Admin.ADD_FISCALYEAR);

        assertNotNull(result);

        FiscalYear fiscalYear = fetch(FiscalYear.class, new FiscalYearId(library.getId(), Integer.parseInt(result)));

        assertNotNull(fiscalYear);

        assertEquals(addFiscalYear.getFirstFiscalYear(),fiscalYear.getFirstFiscalYear());
        assertEquals(addFiscalYear.getSecondFiscalYear(),fiscalYear.getSecondFiscalYear());
        assertEquals(addFiscalYear.getStartDate(),fiscalYear.getStartDate());
        assertEquals(addFiscalYear.getEndDate(),fiscalYear.getEndDate());
        assertEquals(addFiscalYear.getStatus(),fiscalYear.getStatus());
        assertEquals(addFiscalYear.getEntryId(),fiscalYear.getEntryId());
        assertEquals(addFiscalYear.getEntryDate(),fiscalYear.getEntryDate());
    }
}
