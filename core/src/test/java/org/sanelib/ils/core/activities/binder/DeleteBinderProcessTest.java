package org.sanelib.ils.core.activities.binder;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binder.DeleteBinder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteBinderProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteBinderProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Binder binder = new Binder();

        binder.setBinderId(hibernateHelper.getNextId(Binder.class, "binderId.id"), library.getId());
        binder.setName("Test Binder");
        binder.setAddressLine1("Primary Address");
        binder.setAddressLine2("Secondary Address");
        binder.setCity("TestCity");
        binder.setState("TestState");
        binder.setCountry("TestCountry");
        binder.setPin("654321");
        binder.setPrimaryPhone("+91-987654321");
        binder.setSecondaryPhone("+91-879654321");
        binder.setFax("87654321");
        binder.setEmail("user@emailprovider.com");
        binder.setUserCode("user");

        persist(binder);

        DeleteBinder deleteBinder = new DeleteBinder();

        deleteBinder.setId(binder.getBinderId().getId());
        deleteBinder.setLibraryId(library.getId());

        String result = execute(deleteBinder, ActivitiProcessConstants.Admin.DELETE_BINDER);

        assertNull(result);

        Binder dbBinder = fetch(Binder.class, new BinderId(library.getId(), binder.getBinderId().getId()));

        assertNull(dbBinder);
    }
}
