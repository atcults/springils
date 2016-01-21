package org.sanelib.ils.core.activities.binder;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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
        binder.setBinderName("Test Binder");
        binder.setPrimaryAddress("Primary Address");
        binder.setSecondaryAddress("Secondary Address");
        binder.setCity("TestCity");
        binder.setState("TestState");
        binder.setCountry("TestCountry");
        binder.setPin("654321");
        binder.setPrimaryPhoneNumber("+91-987654321");
        binder.setSecondaryPhoneNumber("+91-879654321");
        binder.setFax("87654321");
        binder.setEmail("user@emailprovider.com");
        binder.setEntryId("user");
        binder.setEntryDate(DateHelper.constructDate(2015 , 4 , 1));

        persist(binder);

        Date entryDate = DateHelper.constructDate(2015, 2, 2);

        UpdateBinder updateBinder = new UpdateBinder();

        updateBinder.setId(binder.getBinderId().getId());
        updateBinder.setLibraryId(library.getId());
        updateBinder.setBinderName("Test Update Binder");
        updateBinder.setPrimaryAddress("Primary Address");
        updateBinder.setSecondaryAddress("Secondary Address");
        updateBinder.setCity("TestUpdateCity");
        updateBinder.setState("TestUpdateState");
        updateBinder.setCountry("TestUpdateCountry");
        updateBinder.setPin("654321");
        updateBinder.setPrimaryPhoneNumber("+91-987654321");
        updateBinder.setSecondaryPhoneNumber("+91-879654321");
        updateBinder.setFax("87654321");
        updateBinder.setEmail("user@emailprovider.com");
        updateBinder.setEntryId("user");
        updateBinder.setEntryDate(entryDate);

        String result = execute(updateBinder, ActivitiProcessConstants.Admin.UPDATE_BINDER);

        assertNull(result);

        Binder dbBinder = fetch(Binder.class, new BinderId(library.getId(), binder.getBinderId().getId()));

        assertNotNull(dbBinder);

        assertEquals(updateBinder.getBinderName(),dbBinder.getBinderName());
        assertEquals(updateBinder.getPrimaryAddress(),dbBinder.getPrimaryAddress());
        assertEquals(updateBinder.getSecondaryAddress(),dbBinder.getSecondaryAddress());
        assertEquals(updateBinder.getCity(),dbBinder.getCity());
        assertEquals(updateBinder.getState(), dbBinder.getState());
        assertEquals(updateBinder.getCountry(),dbBinder.getCountry());
        assertEquals(updateBinder.getPin(),dbBinder.getPin());
        assertEquals(updateBinder.getPrimaryPhoneNumber(),dbBinder.getPrimaryPhoneNumber());
        assertEquals(updateBinder.getSecondaryPhoneNumber(),dbBinder.getSecondaryPhoneNumber());
        assertEquals(updateBinder.getFax(),dbBinder.getFax());
        assertEquals(updateBinder.getEmail(),dbBinder.getEmail());
        assertEquals(updateBinder.getEntryId(),dbBinder.getEntryId());
        assertEquals(entryDate,dbBinder.getEntryDate());



    }
}
