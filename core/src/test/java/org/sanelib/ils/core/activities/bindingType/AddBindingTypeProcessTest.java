package org.sanelib.ils.core.activities.bindingType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddBindingTypeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddBindingTypeProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddBindingType addBindingType = new AddBindingType();

        addBindingType.setLibraryId(library.getId());
        addBindingType.setBindType("BindType");
        addBindingType.setPrice(500);
        addBindingType.setEntryId("EntryId01");
        addBindingType.setEntryDate(DateHelper.fromDateString("2007/01/02"));

        String result = execute(addBindingType, ActivitiProcessConstants.Admin.ADD_BINDING_TYPE);

        assertNotNull(result);

        BindingType bindingType = fetch(BindingType.class, new BindingTypeId(library.getId(), Integer.parseInt(result)));

        assertNotNull(bindingType);

        assertEquals(addBindingType.getBindType() ,bindingType.getBindType());
        assertEquals(addBindingType.getPrice() ,bindingType.getPrice());
        assertEquals(addBindingType.getEntryId() ,bindingType.getEntryId());
        assertEquals(addBindingType.getEntryDate() ,bindingType.getEntryDate());
    }
}
