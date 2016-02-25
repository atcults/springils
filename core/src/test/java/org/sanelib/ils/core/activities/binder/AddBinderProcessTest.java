package org.sanelib.ils.core.activities.binder;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
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
        addBinder.setBinderName("Test Binder");
        addBinder.setPrimaryAddress("Primary Address");
        addBinder.setSecondaryAddress("Secondary Address");
        addBinder.setCity("TestCity");
        addBinder.setState("TestState");
        addBinder.setCountry("TestCountry");
        addBinder.setPin("654321");
        addBinder.setPrimaryPhoneNumber("+91-987654321");
        addBinder.setSecondaryPhoneNumber("+91-879654321");
        addBinder.setFax("87654321");
        addBinder.setEmail("user@emailprovider.com");
        addBinder.setEntryId("user");
        addBinder.setEntryDate(DateHelper.constructDate(2015 , 4 , 1));

        String result = execute(addBinder, ActivitiProcessConstants.Admin.ADD_BINDER);

        assertNotNull(result);

        Binder binder = fetch(Binder.class, new BinderId(library.getId(), Integer.parseInt(result)));

        assertNotNull(binder);

        assertEquals(addBinder.getBinderName() , binder.getBinderName());
        assertEquals(addBinder.getPrimaryAddress() , binder.getPrimaryAddress());
        assertEquals(addBinder.getSecondaryAddress() , binder.getSecondaryAddress());
        assertEquals(addBinder.getCity() , binder.getCity());
        assertEquals(addBinder.getState() , binder.getState());
        assertEquals(addBinder.getCountry() , binder.getCountry());
        assertEquals(addBinder.getPin() , binder.getPin());
        assertEquals(addBinder.getPrimaryPhoneNumber() , binder.getPrimaryPhoneNumber());
        assertEquals(addBinder.getSecondaryPhoneNumber() , binder.getSecondaryPhoneNumber());
        assertEquals(addBinder.getFax() , binder.getFax());
        assertEquals(addBinder.getEmail() , binder.getEmail());
        assertEquals(addBinder.getEntryId() , binder.getEntryId());

    }
}
