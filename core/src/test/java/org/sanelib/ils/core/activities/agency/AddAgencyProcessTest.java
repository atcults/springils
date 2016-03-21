package org.sanelib.ils.core.activities.agency;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.AgencyId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddAgencyProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddAgencyProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddAgency addAgency = new AddAgency();

        addAgency.setLibraryId(library.getId());
        addAgency.setName("name");

        String result = execute(addAgency, ActivitiProcessConstants.Admin.ADD_AGENCY);

        assertNotNull(result);

        Agency agency = fetch(Agency.class, new AgencyId(library.getId(), Integer.parseInt(result)));

        assertNotNull(agency);

        assertEquals(addAgency.getName(), agency.getName());
    }
}
