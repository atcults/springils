package org.sanelib.ils.core.activities.patronCategory;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
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
        patronCategory.setPatronCategoryName("patronCategory");

        persist(patronCategory);

        UpdatePatronCategory updatePatronCategory = new UpdatePatronCategory();

        updatePatronCategory.setId(patronCategory.getPatronCategoryId().getId());
        updatePatronCategory.setLibraryId(library.getId());
        updatePatronCategory.setPatronCategoryName("updated PatronCategory");
        updatePatronCategory.setIllThruNet("T");
        updatePatronCategory.setRenewalThruNet("T");
        updatePatronCategory.setEntryDate(DateHelper.fromDateString("2007/02/02"));
        updatePatronCategory.setOverallLoanLimit(3);
        updatePatronCategory.setAllowMultipleCopies("M");
        updatePatronCategory.setAcqWorkflow("NewAcqWorkflow");

        String result = execute(updatePatronCategory, ActivitiProcessConstants.Admin.UPDATE_PATRON_CATEGORY);

        assertNull(result);

        PatronCategory dbPatronCategory = fetch(PatronCategory.class, new PatronCategoryId(library.getId(), patronCategory.getPatronCategoryId().getId()));

        assertNotNull(dbPatronCategory);

        assertEquals(updatePatronCategory.getPatronCategoryName(), dbPatronCategory.getPatronCategoryName());
        assertEquals(updatePatronCategory.getIllThruNet(), dbPatronCategory.getIllThruNet());
        assertEquals(updatePatronCategory.getRenewalThruNet(), dbPatronCategory.getRenewalThruNet());
        assertEquals(updatePatronCategory.getEntryDate(), dbPatronCategory.getEntryDate());
        assertEquals(updatePatronCategory.getOverallLoanLimit(), dbPatronCategory.getOverallLoanLimit());
        assertEquals(updatePatronCategory.getAllowMultipleCopies(), dbPatronCategory.getAllowMultipleCopies());
        assertEquals(updatePatronCategory.getAcqWorkflow(), dbPatronCategory.getAcqWorkflow());
    }
}
