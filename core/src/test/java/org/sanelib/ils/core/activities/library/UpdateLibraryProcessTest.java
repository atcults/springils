package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UpdateLibraryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdatePublisherProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");
        library.setCity("City");
        library.setState("State");
        library.setCountry("Country");

        persist(library);

        UpdateLibrary updateLibrary = new UpdateLibrary();
        updateLibrary.setId(1);
        updateLibrary.setName("new name");
        updateLibrary.setCity("new city");
        updateLibrary.setState("new state");
        updateLibrary.setCountry("new country");

        String result = execute(updateLibrary, ActivitiProcessConstants.Admin.UPDATE_LIBRARY);

        assertNull(result);

        Library updatedLibrary = fetch(Library.class, updateLibrary.getId());

        assertNotNull(library);

        assertEquals((int) updateLibrary.getId(), updatedLibrary.getId());
        assertEquals(updateLibrary.getName() ,updatedLibrary.getName());
        assertEquals(updateLibrary.getCity() , updatedLibrary.getCity());
        assertEquals(updateLibrary.getState() ,updatedLibrary.getState());
        assertEquals(updateLibrary.getCountry() ,updatedLibrary.getCountry());
    }
}
