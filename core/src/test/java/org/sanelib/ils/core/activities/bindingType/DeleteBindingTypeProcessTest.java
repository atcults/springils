package org.sanelib.ils.core.activities.bindingType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.agency.DeleteAgency;
import org.sanelib.ils.core.commands.bindingType.DeleteBindingType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteBindingTypeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteAgencyProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        BindingType bindingType = new BindingType();

        bindingType.setBindingTypeId(hibernateHelper.getNextId(BindingType.class, "bindingTypeId.id"), library.getId());
        bindingType.setBindType("BindType");

        persist(bindingType);

        DeleteBindingType deleteBindingType = new DeleteBindingType();

        deleteBindingType.setId(bindingType.getBindingTypeId().getId());
        deleteBindingType.setLibraryId(library.getId());

        String result = execute(deleteBindingType, ActivitiProcessConstants.Admin.DELETE_BINDING_TYPE);

        assertNull(result);

        BindingType dbBindingType = fetch(BindingType.class, new BindingTypeId(library.getId(), bindingType.getBindingTypeId().getId()));

        assertNull(dbBindingType);
    }
}
