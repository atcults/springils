package org.sanelib.ils.core.activities.patronCategory;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patronCategory.UpdatePatronCategory;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UpdatePatronCategoryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdatePatronCategoryProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        PatronCategory patronCategory = new PatronCategory();

        patronCategory.setPatronCategoryId(hibernateHelper.getNextId(PatronCategory.class, "patronCategoryId.id"), library.getId());
        patronCategory.setName("patronCategory");

        persist(patronCategory);

        UpdatePatronCategory updatePatronCategory = new UpdatePatronCategory();

        updatePatronCategory.setId(patronCategory.getPatronCategoryId().getId());
        updatePatronCategory.setLibraryId(library.getId());
        updatePatronCategory.setName("updated PatronCategory");
        updatePatronCategory.setAllowILLFromNet(true);
        updatePatronCategory.setAllowRenewalFromNet(true);
        updatePatronCategory.setOverallLoanLimit(3);
        updatePatronCategory.setAllowMultipleCopies(true);
        updatePatronCategory.setAcqWorkflow("NewAcqWorkflow");

        String result = execute(updatePatronCategory, ActivitiProcessConstants.Admin.UPDATE_PATRON_CATEGORY);

        assertNull(result);

        PatronCategory dbPatronCategory = fetch(PatronCategory.class, new PatronCategoryId(library.getId(), patronCategory.getPatronCategoryId().getId()));

        assertNotNull(dbPatronCategory);

        assertEquals(updatePatronCategory.getName(), dbPatronCategory.getName());
        assertEquals(updatePatronCategory.isAllowILLFromNet(), dbPatronCategory.isAllowILLFromNet());
        assertEquals(updatePatronCategory.isAllowRenewalFromNet(), dbPatronCategory.isAllowRenewalFromNet());
        assertEquals(updatePatronCategory.getOverallLoanLimit(), dbPatronCategory.getOverallLoanLimit());
        assertEquals(updatePatronCategory.isAllowMultipleCopies(), dbPatronCategory.isAllowMultipleCopies());
        assertEquals(updatePatronCategory.getAcqWorkflow(), dbPatronCategory.getAcqWorkflow());
    }
}
