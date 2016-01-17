package org.sanelib.ils.core.activities.agency;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.AgencyId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdateAgencyProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateAgencyProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Agency agency = new Agency();

        agency.setAgencyId(hibernateHelper.getNextId(Agency.class, "agencyId.id"), library.getId());
        agency.setName("agency");

        persist(agency);

        UpdateAgency updateAgency = new UpdateAgency();

        updateAgency.setId(agency.getAgencyId().getId());
        updateAgency.setLibraryId(library.getId());
        updateAgency.setName("updated agency");

        String result = execute(updateAgency, ActivitiProcessConstants.Admin.UPDATE_AGENCY);

        assertNull(result);

        Agency dbAgency = fetch(Agency.class, new AgencyId(library.getId(), agency.getAgencyId().getId()));

        assertNotNull(dbAgency);

        assertEquals(updateAgency.getName(), dbAgency.getName());
    }
}
