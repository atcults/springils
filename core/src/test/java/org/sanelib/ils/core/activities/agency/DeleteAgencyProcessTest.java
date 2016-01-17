package org.sanelib.ils.core.activities.agency;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.agency.DeleteAgency;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.AgencyId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteAgencyProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteAgencyProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Agency agency = new Agency();

        agency.setAgencyId(hibernateHelper.getNextId(Agency.class, "agencyId.id"), library.getId());
        agency.setName("agency");

        persist(agency);

        DeleteAgency deleteAgency = new DeleteAgency();

        deleteAgency.setId(agency.getAgencyId().getId());
        deleteAgency.setLibraryId(library.getId());

        String result = execute(deleteAgency, ActivitiProcessConstants.Admin.DELETE_AGENCY);

        assertNull(result);

        Agency dbAgency = fetch(Agency.class, new AgencyId(library.getId(), agency.getAgencyId().getId()));

        assertNull(dbAgency);
    }
}
