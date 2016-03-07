package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.DeleteLibrary;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteLibraryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteLibrarySuccess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");
        library.setCity("City");
        library.setState("State");
        library.setCountry("Country");

        persist(library);

        DeleteLibrary deleteLibrary = new DeleteLibrary();
        deleteLibrary.setId(library.getId());

        String result = execute(deleteLibrary, ActivitiProcessConstants.Admin.DELETE_LIBRARY);

        assertNull(result);

        Library deletedEntity = fetch(deleteLibrary.getRootEntityClass(), library.getId());

        assertNull(deletedEntity);
    }
}
