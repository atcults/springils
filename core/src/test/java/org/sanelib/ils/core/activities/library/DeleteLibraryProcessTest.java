package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.DeleteLibrary;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteLibraryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteLibrarySuccess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("name");
        library.setSerialMaster("SerialMaster");
        library.setCatalogueMaster("CatalogueMaster");
        library.setAcquisitionsMaster("AcquisitionMaster");
        library.setCreatedOn(DateHelper.constructDate(2015 , 12 ,12));
        library.setAcquisitionStatus("AcqStatus");
        library.setCataloguingStatus("CatStatus");
        library.setSmStatus("SmStatus");
        library.setHostLibraryId(100);
        library.setFirstAddress("FirstAddress");
        library.setSecondAddress("SecondAddress");
        library.setCity("city");
        library.setState("ST");
        library.setPin("54321");
        library.setFirstPhoneNumber("+91-987654321");
        library.setEmail("user@emailprovider.com");
        library.setSecondPhoneNumber("+91-897654321");
        library.setFax("87654321");
        library.setCountry("country");
        library.setNetworkName("Network Name");
        library.setSearchForms("Search Forms");
        library.setFacebookWidget("Facebook Widget");
        library.setTwitterWidget("Twitter Widget");
        library.setAboutLibrary("About Library");
        library.setAboutOrganization("About Organization");
        library.setLibraryTimings("Library Timings");
        library.setContactUs("Contact Us");
        library.setMapWidget("Map Widget");
        library.setDescription("Description");
        library.setWebStatistics("Web Statistics");

        persist(library);

        DeleteLibrary deleteLibrary = new DeleteLibrary();
        deleteLibrary.setId(library.getId());

        String result = execute(deleteLibrary, ActivitiProcessConstants.Admin.DELETE_LIBRARY);

        assertNull(result);

        Library deletedEntity = fetch(deleteLibrary.getRootEntityClass(), library.getId());

        assertNull(deletedEntity);
    }
}
