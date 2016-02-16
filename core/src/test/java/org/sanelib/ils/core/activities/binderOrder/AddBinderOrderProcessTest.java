package org.sanelib.ils.core.activities.binderOrder;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.BinderOrder;
import org.sanelib.ils.core.domain.entity.BinderOrderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddBinderOrderProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddBinderOrderProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddBinderOrder addBinderOrder = new AddBinderOrder();

        addBinderOrder.setLibraryId(library.getId());
        addBinderOrder.setBinderId(101);
        addBinderOrder.setOrderDate(DateHelper.constructDate(2015 , 11, 10));
        addBinderOrder.setDueDate(DateHelper.constructDate(2015 , 11, 25));
        addBinderOrder.setReturnedDate(DateHelper.constructDate(2015 , 11 , 24));
        addBinderOrder.setFormLetterNo("FormLetterNumber");
        addBinderOrder.setSubject("Subject");
        addBinderOrder.setContent("Content");
        addBinderOrder.setMailStatus(true);
        addBinderOrder.setPrintStatus(true);
        addBinderOrder.setStatus("SetStatus");
        addBinderOrder.setEntryId("EntryId");

        String result = execute(addBinderOrder, ActivitiProcessConstants.Admin.ADD_BINDERORDER);

        assertNotNull(result);

        BinderOrder binderOrder = fetch(BinderOrder.class, new BinderOrderId(library.getId(), Integer.parseInt(result)));

        assertNotNull(binderOrder);

        assertEquals(addBinderOrder.getBinderId() ,binderOrder.getBinderId());
        assertEquals(addBinderOrder.getOrderDate() ,binderOrder.getOrderDate());
        assertEquals(addBinderOrder.getDueDate() ,binderOrder.getDueDate());
        assertEquals(addBinderOrder.getReturnedDate() ,binderOrder.getReturnedDate());
        assertEquals(addBinderOrder.getFormLetterNo() ,binderOrder.getFormLetterNo());
        assertEquals(addBinderOrder.getSubject() ,binderOrder.getSubject());
        assertEquals(addBinderOrder.getContent() ,binderOrder.getContent());
        assertEquals(addBinderOrder.isMailStatus() ,binderOrder.isMailStatus());
        assertEquals(addBinderOrder.isPrintStatus() ,binderOrder.isPrintStatus());
        assertEquals(addBinderOrder.getStatus() ,binderOrder.getStatus());
        assertEquals(addBinderOrder.getEntryId() ,binderOrder.getEntryId());
    }
}
