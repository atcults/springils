package org.sanelib.ils.core.activities.binder;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdateBinderProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateBinderProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Binder binder=new Binder();

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

        UpdateBinder updateBinder = new UpdateBinder();

        updateBinder.setId(binder.getBinderId().getId());
        updateBinder.setLibraryId(library.getId());
        updateBinder.setName("Test Update Binder");
        updateBinder.setPrimaryAddress("Primary Address");
        updateBinder.setSecondaryAddress("Secondary Address");
        updateBinder.setCity("TestUpdateCity");
        updateBinder.setState("TestUpdateState");
        updateBinder.setCountry("TestUpdateCountry");
        updateBinder.setPin("654321");
        updateBinder.setPrimaryPhone("+91-9876543210");
        updateBinder.setSecondaryPhone("+91-8796543210");
        updateBinder.setFax("+91-9876543210");
        updateBinder.setEmail("user@emailprovider.com");
        updateBinder.setUserCode("user");

        String result = execute(updateBinder, ActivitiProcessConstants.Admin.UPDATE_BINDER);

        assertNull(result);

        Binder dbBinder = fetch(Binder.class, new BinderId(library.getId(), binder.getBinderId().getId()));

        assertNotNull(dbBinder);

        assertEquals(updateBinder.getName(), dbBinder.getName());
        assertEquals(updateBinder.getPrimaryAddress(), dbBinder.getAddressLine1());
        assertEquals(updateBinder.getSecondaryAddress(), dbBinder.getAddressLine2());
        assertEquals(updateBinder.getCity(), dbBinder.getCity());
        assertEquals(updateBinder.getState(), dbBinder.getState());
        assertEquals(updateBinder.getCountry(), dbBinder.getCountry());
        assertEquals(updateBinder.getPin(), dbBinder.getPin());
        assertEquals(updateBinder.getPrimaryPhone(), dbBinder.getPrimaryPhone());
        assertEquals(updateBinder.getSecondaryPhone(), dbBinder.getSecondaryPhone());
        assertEquals(updateBinder.getFax(), dbBinder.getFax());
        assertEquals(updateBinder.getEmail(), dbBinder.getEmail());
        assertEquals(updateBinder.getUserCode(), dbBinder.getUserCode());
    }
}
