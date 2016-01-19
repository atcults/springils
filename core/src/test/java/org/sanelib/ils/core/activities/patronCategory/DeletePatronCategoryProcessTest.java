package org.sanelib.ils.core.activities.patronCategory;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patronCategory.DeletePatronCategory;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeletePatronCategoryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeletePatronCategoryProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        PatronCategory patronCategory = new PatronCategory();

        patronCategory.setPatronCategoryId(hibernateHelper.getNextId(PatronCategory.class, "patronCategoryId.id"), library.getId());
        patronCategory.setPatronCategoryName("patronCategory");

        persist(patronCategory);

        DeletePatronCategory deletePatronCategory = new DeletePatronCategory();

        deletePatronCategory.setId(patronCategory.getPatronCategoryId().getId());
        deletePatronCategory.setLibraryId(library.getId());

        String result = execute(deletePatronCategory, ActivitiProcessConstants.Admin.DELETE_PATRON_CATEGORY);

        assertNull(result);

        PatronCategory dbPatronCategory = fetch(PatronCategory.class, new PatronCategoryId(library.getId(), patronCategory.getPatronCategoryId().getId()));

        assertNull(dbPatronCategory);
    }
}
