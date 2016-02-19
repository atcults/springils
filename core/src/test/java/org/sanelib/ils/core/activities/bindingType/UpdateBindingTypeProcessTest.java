package org.sanelib.ils.core.activities.bindingType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.BindingType;
import org.sanelib.ils.core.domain.entity.BindingTypeId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class UpdateBindingTypeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateBindingTypeProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        BindingType bindingType = new BindingType();

        bindingType.setBindingTypeId(hibernateHelper.getNextId(BindingType.class, "bindingTypeId.id"), library.getId());
        bindingType.setBindType("BindType");

        persist(bindingType);

        UpdateBindingType updateBindingType = new UpdateBindingType();

        updateBindingType.setId(bindingType.getBindingTypeId().getId());
        updateBindingType.setLibraryId(library.getId());
        updateBindingType.setBindType("updated bindingType");
        bindingType.setPrice(500.00);

        String result = execute(updateBindingType, ActivitiProcessConstants.Admin.UPDATE_BINDING_TYPE);

        assertNull(result);

        BindingType dbBindingType = fetch(BindingType.class, new BindingTypeId(library.getId(), bindingType.getBindingTypeId().getId()));

        assertNotNull(dbBindingType);

        assertEquals(updateBindingType.getBindType(), dbBindingType.getBindType());
        assertEquals(updateBindingType.getPrice(), dbBindingType.getPrice());

    }
}
