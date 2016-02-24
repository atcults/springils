package org.sanelib.ils.core.activities.patronCategory;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
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
    public void testAddPatronCategoryProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddPatronCategory addPatronCategory = new AddPatronCategory();

        addPatronCategory.setLibraryId(library.getId());
        addPatronCategory.setName("PCName");
        addPatronCategory.setAllowILLFromNet(true);
        addPatronCategory.setAllowRenewalFromNet(true);
        addPatronCategory.setOverallLoanLimit(2);
        addPatronCategory.setAllowMultipleCopies(true);
        addPatronCategory.setAcqWorkflow("AcqWorkflow");

        String result = execute(addPatronCategory, ActivitiProcessConstants.Admin.ADD_PATRON_CATEGORY);

        assertNotNull(result);

        PatronCategory patronCategory = fetch(PatronCategory.class, new PatronCategoryId(library.getId(), Integer.parseInt(result)));

        assertNotNull(patronCategory);

        assertEquals(addPatronCategory.getName(), patronCategory.getName());
        assertEquals(addPatronCategory.isAllowILLFromNet(), patronCategory.isAllowILLFromNet());
        assertEquals(addPatronCategory.isAllowRenewalFromNet(), patronCategory.isAllowRenewalFromNet());
        assertEquals(addPatronCategory.getOverallLoanLimit(), patronCategory.getOverallLoanLimit());
        assertEquals(addPatronCategory.isAllowMultipleCopies(), patronCategory.isAllowMultipleCopies());
        assertEquals(addPatronCategory.getAcqWorkflow(), patronCategory.getAcqWorkflow());
    }
}
