package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdateLibraryProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateLibraryProcess() throws Throwable {

        Library library = new Library();

        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("name");
        library.setSerialMaster("SerialMaster");
        library.setCatalogueMaster("CatalogueMaster");
        library.setAcquisitionsMaster("AcquisitionMaster");
        library.setCreatedOn(DateHelper.constructDate(2015, 12, 12));
        library.setAcquisitionStatus("AcqStatus");
        library.setCataloguingStatus("CatStatus");
        library.setSmStatus("SmStatus");
        library.setHostLibraryId(1);
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

        UpdateLibrary updateLibrary = new UpdateLibrary();

        updateLibrary.setId(1);
        updateLibrary.setName("Updated name");
        updateLibrary.setSerialMaster("SerialMaster");
        updateLibrary.setCatalogueMaster("CatalogueMaster");
        updateLibrary.setAcquisitionsMaster("AcquisitionMaster");
        updateLibrary.setCreatedOn(DateHelper.constructDate(2015, 12, 12));
        updateLibrary.setAcquisitionStatus("AcqStatus");
        updateLibrary.setCataloguingStatus("CatStatus");
        updateLibrary.setSmStatus("SmStatus");
        updateLibrary.setHostLibraryId(1);
        updateLibrary.setFirstAddress("Updated FirstAddress");
        updateLibrary.setSecondAddress("Updated SecondAddress");
        updateLibrary.setCity("Updated city");
        updateLibrary.setState("ST");
        updateLibrary.setPin("54321");
        updateLibrary.setFirstPhoneNumber("+91-987654321");
        updateLibrary.setEmail("user@emailprovider.com");
        updateLibrary.setSecondPhoneNumber("+91-897654321");
        updateLibrary.setFax("87654321");
        updateLibrary.setCountry("country");
        updateLibrary.setNetworkName("Updated Network Name");
        updateLibrary.setSearchForms("Updated Search Forms");
        updateLibrary.setFacebookWidget("Facebook Widget");
        updateLibrary.setTwitterWidget("Twitter Widget");
        updateLibrary.setAboutLibrary("About Library");
        updateLibrary.setAboutOrganization("About Organization");
        updateLibrary.setLibraryTimings("Updated Library Timings");
        updateLibrary.setContactUs("Contact Us");
        updateLibrary.setMapWidget("Map Widget");
        updateLibrary.setDescription("Updated Description");
        updateLibrary.setWebStatistics("Web Statistics");

        String result = execute(updateLibrary, ActivitiProcessConstants.Admin.UPDATE_LIBRARY);

        assertNull(result);

        Library updatedLibrary = fetch(Library.class, updateLibrary.getId());

        assertNotNull(library);

        assertEquals((int) updateLibrary.getId(), updatedLibrary.getId());
        assertEquals(updateLibrary.getName(), updatedLibrary.getName());
        assertEquals(updateLibrary.getSerialMaster(), updatedLibrary.getSerialMaster());
        assertEquals(updateLibrary.getCatalogueMaster(), updatedLibrary.getCatalogueMaster());
        assertEquals(updateLibrary.getAcquisitionsMaster(), updatedLibrary.getAcquisitionsMaster());
        assertEquals(updateLibrary.getCreatedOn(), updatedLibrary.getCreatedOn());
        assertEquals(updateLibrary.getAcquisitionStatus(), updatedLibrary.getAcquisitionStatus());
        assertEquals(updateLibrary.getCataloguingStatus(), updatedLibrary.getCataloguingStatus());
        assertEquals(updateLibrary.getSmStatus(), updatedLibrary.getSmStatus());
        assertEquals(updateLibrary.getHostLibraryId(), updatedLibrary.getHostLibraryId());
        assertEquals(updateLibrary.getFirstAddress(), updatedLibrary.getFirstAddress());
        assertEquals(updateLibrary.getSecondAddress(), updatedLibrary.getSecondAddress());
        assertEquals(updateLibrary.getCity(), updatedLibrary.getCity());
        assertEquals(updateLibrary.getState(), updatedLibrary.getState());
        assertEquals(updateLibrary.getPin(), updatedLibrary.getPin());
        assertEquals(updateLibrary.getFirstPhoneNumber(), updatedLibrary.getFirstPhoneNumber());
        assertEquals(updateLibrary.getEmail(), updatedLibrary.getEmail());
        assertEquals(updateLibrary.getSecondPhoneNumber(), updatedLibrary.getSecondPhoneNumber());
        assertEquals(updateLibrary.getFax(), updatedLibrary.getFax());
        assertEquals(updateLibrary.getCountry(), updatedLibrary.getCountry());
        assertEquals(updateLibrary.getNetworkName(), updatedLibrary.getNetworkName());
        assertEquals(updateLibrary.getSearchForms(), updatedLibrary.getSearchForms());
        assertEquals(updateLibrary.getFacebookWidget(), updatedLibrary.getFacebookWidget());
        assertEquals(updateLibrary.getTwitterWidget(), updatedLibrary.getTwitterWidget());
        assertEquals(updateLibrary.getAboutLibrary(), updatedLibrary.getAboutLibrary());
        assertEquals(updateLibrary.getAboutOrganization(), updatedLibrary.getAboutOrganization());
        assertEquals(updateLibrary.getLibraryTimings(), updatedLibrary.getLibraryTimings());
        assertEquals(updateLibrary.getContactUs(), updatedLibrary.getContactUs());
        assertEquals(updateLibrary.getMapWidget(), updatedLibrary.getMapWidget());
        assertEquals(updateLibrary.getDescription(), updatedLibrary.getDescription());
        assertEquals(updateLibrary.getWebStatistics(), updatedLibrary.getWebStatistics());
    }
}
