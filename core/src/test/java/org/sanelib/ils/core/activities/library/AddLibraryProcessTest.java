package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.domain.entity.Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddLibraryProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testAddLibraryProcess() throws Throwable {

        AddLibrary addLibrary = new AddLibrary();

        addLibrary.setName("name");
        addLibrary.setCity("city");
        addLibrary.setState("ST");
        addLibrary.setCountry("country");

        String result = execute(addLibrary, ActivitiProcessConstants.Admin.ADD_LIBRARY);

        assertNotNull(result);

        Integer libraryId = Integer.parseInt(result);

        Library library = fetch(Library.class, libraryId);

        assertNotNull(library);

        assertEquals(addLibrary.getName(), library.getName());
        assertEquals(addLibrary.getCity(), library.getCity());
        assertEquals(addLibrary.getState(), library.getState());
        assertEquals(addLibrary.getCountry(), library.getCountry());
    }
}
