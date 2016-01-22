package org.sanelib.ils.core.activities.binderOrder;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.binderOrder.DeleteBinderOrder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.BinderOrder;
import org.sanelib.ils.core.domain.entity.BinderOrderId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteBinderOrderProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteBinderOrderProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        BinderOrder binderOrder = new BinderOrder();

        binderOrder.setBinderOrderId(hibernateHelper.getNextId(BinderOrder.class, "binderOrderId.id"), library.getId());
        binderOrder.setBinderId(101);
        binderOrder.setOrderDate(DateHelper.constructDate(2015 , 11, 10));
        binderOrder.setDueDate(DateHelper.constructDate(2015 , 11, 25));
        binderOrder.setReturnedDate(DateHelper.constructDate(2015 , 11 , 24));
        binderOrder.setFormLetterNo("FormLetterNumber");
        binderOrder.setSubject("Subject");
        binderOrder.setContent("Content");
        binderOrder.setMailStatus("M");
        binderOrder.setPrintStatus("P");
        binderOrder.setStatus("SetStatus");
        binderOrder.setEntryId("EntryId");
        binderOrder.setEntryDate(DateHelper.constructDate(2015 , 11 ,10));

        persist(binderOrder);

        DeleteBinderOrder deleteBinderOrder = new DeleteBinderOrder();

        deleteBinderOrder.setId(binderOrder.getBinderOrderId().getId());
        deleteBinderOrder.setLibraryId(library.getId());

        String result = execute(deleteBinderOrder, ActivitiProcessConstants.Admin.DELETE_BINDERORDER);

        assertNull(result);

        BinderOrder dbBinderOrder = fetch(BinderOrder.class, new BinderOrderId(library.getId(), binderOrder.getBinderOrderId().getId()));

        assertNull(dbBinderOrder);
    }
}
