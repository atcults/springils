package org.sanelib.ils.core.activities.binder;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddBinderProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddBinderProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddBinder addBinder = new AddBinder();

        addBinder.setLibraryId(library.getId());
        addBinder.setName("Test Binder");
        addBinder.setAddressLine1("Address Line1");
        addBinder.setAddressLine2("Address Line2");
        addBinder.setCity("TestCity");
        addBinder.setState("TestState");
        addBinder.setCountry("TestCountry");
        addBinder.setPin("654321");
        addBinder.setPrimaryPhone("+91-9876543210");
        addBinder.setSecondaryPhone("+91-8796543210");
        addBinder.setFax("+91-9876543210");
        addBinder.setEmail("user@emailprovider.com");
        addBinder.setUserCode("user");

        String result = execute(addBinder, ActivitiProcessConstants.Admin.ADD_BINDER);

        assertNotNull(result);

        Binder binder = fetch(Binder.class, new BinderId(library.getId(), Integer.parseInt(result)));

        assertNotNull(binder);

        assertEquals(addBinder.getName(), binder.getName());
        assertEquals(addBinder.getAddressLine1(), binder.getAddressLine1());
        assertEquals(addBinder.getAddressLine2(), binder.getAddressLine2());
        assertEquals(addBinder.getCity(), binder.getCity());
        assertEquals(addBinder.getState(), binder.getState());
        assertEquals(addBinder.getCountry(), binder.getCountry());
        assertEquals(addBinder.getPin(), binder.getPin());
        assertEquals(addBinder.getPrimaryPhone(), binder.getPrimaryPhone());
        assertEquals(addBinder.getSecondaryPhone(), binder.getSecondaryPhone());
        assertEquals(addBinder.getFax(), binder.getFax());
        assertEquals(addBinder.getEmail(), binder.getEmail());
        assertEquals(addBinder.getUserCode(), binder.getUserCode());
    }
}
