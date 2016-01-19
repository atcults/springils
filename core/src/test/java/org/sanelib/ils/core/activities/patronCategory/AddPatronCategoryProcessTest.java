package org.sanelib.ils.core.activities.patronCategory;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddPatronCategoryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddPatronCategroyProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddPatronCategory addPatronCategory = new AddPatronCategory();

        addPatronCategory.setLibraryId(library.getId());
        addPatronCategory.setPatronCategoryName("PCName");
        addPatronCategory.setIllThruNet("I");
        addPatronCategory.setRenewalThruNet("R");
        addPatronCategory.setEntryDate(DateHelper.fromDateString("2007/01/02"));
        addPatronCategory.setOverallLoanLimit(2);
        addPatronCategory.setAllowMultipleCopies("M");
        addPatronCategory.setAcqWorkflow("AcqWorkflow");

        String result = execute(addPatronCategory, ActivitiProcessConstants.Admin.ADD_PATRON_CATEGORY);

        assertNotNull(result);

        PatronCategory patronCategory = fetch(PatronCategory.class, new PatronCategoryId(library.getId(), Integer.parseInt(result)));

        assertNotNull(patronCategory);

        assertEquals(addPatronCategory.getPatronCategoryName() ,patronCategory.getPatronCategoryName());
        assertEquals(addPatronCategory.getPatronCategoryName(),patronCategory.getPatronCategoryName());
        assertEquals(addPatronCategory.getIllThruNet(),patronCategory.getIllThruNet());
        assertEquals(addPatronCategory.getRenewalThruNet(),patronCategory.getRenewalThruNet());
        assertEquals(addPatronCategory.getEntryDate(),patronCategory.getEntryDate());
        assertEquals(addPatronCategory.getOverallLoanLimit(),patronCategory.getOverallLoanLimit());
        assertEquals(addPatronCategory.getAllowMultipleCopies(),patronCategory.getAllowMultipleCopies());
        assertEquals(addPatronCategory.getAcqWorkflow(),patronCategory.getAcqWorkflow());
    }
}
