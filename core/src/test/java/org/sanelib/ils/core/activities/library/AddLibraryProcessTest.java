package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.domain.entity.Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddLibraryProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testAddLibraryProcess() throws Throwable {

        AddLibrary addLibrary = new AddLibrary();

        addLibrary.setName("name");
        addLibrary.setSerialMaster("SerialMaster");
        addLibrary.setCatalogueMaster("CatalogueMaster");
        addLibrary.setAcquisitionsMaster("AcquisitionMaster");
        addLibrary.setCreatedOn(DateHelper.constructDate(2015, 12, 12));
        addLibrary.setAcquisitionStatus("AcqStatus");
        addLibrary.setCataloguingStatus("CatStatus");
        addLibrary.setSmStatus("SmStatus");
        addLibrary.setHostLibraryId(1);
        addLibrary.setAddressLine1("Address Line1");
        addLibrary.setAddressLine2("Address Line2");
        addLibrary.setCity("city");
        addLibrary.setState("ST");
        addLibrary.setPin("54321");
        addLibrary.setPrimaryPhone(StringHelper.convertPhoneNumber("+91-9876543210"));
        addLibrary.setEmail("user@emailprovider.com");
        addLibrary.setSecondaryPhone("+91-897654321");
        addLibrary.setFax("+91-9876543210");
        addLibrary.setCountry("country");
        addLibrary.setNetworkName("Network Name");
        addLibrary.setSearchForms("Search Forms");
        addLibrary.setFacebookWidget("Facebook Widget");
        addLibrary.setTwitterWidget("Twitter Widget");
        addLibrary.setAboutLibrary("About Library");
        addLibrary.setAboutOrganization("About Organization");
        addLibrary.setLibraryTimings("Library Timings");
        addLibrary.setContactUs("Contact Us");
        addLibrary.setMapWidget("Map Widget");
        addLibrary.setDescription("Description");
        addLibrary.setWebStatistics("Web Statistics");

        String result = execute(addLibrary, ActivitiProcessConstants.Admin.ADD_LIBRARY);

        assertNotNull(result);

        Integer libraryId = Integer.parseInt(result);

        Library library = fetch(Library.class, libraryId);

        assertNotNull(library);

        assertEquals(addLibrary.getName(), library.getName());
        assertEquals(addLibrary.getSerialMaster(), library.getSerialMaster());
        assertEquals(addLibrary.getCatalogueMaster(), library.getCatalogueMaster());
        assertEquals(addLibrary.getAcquisitionsMaster(), library.getAcquisitionsMaster());
        assertEquals(addLibrary.getCreatedOn(), library.getCreatedOn());
        assertEquals(addLibrary.getAcquisitionStatus(), library.getAcquisitionStatus());
        assertEquals(addLibrary.getCataloguingStatus(), library.getCataloguingStatus());
        assertEquals(addLibrary.getSmStatus(), library.getSmStatus());
        assertEquals(addLibrary.getHostLibraryId(), library.getHostLibraryId());
        assertEquals(addLibrary.getAddressLine1(), library.getAddressLine1());
        assertEquals(addLibrary.getAddressLine2(), library.getAddressLine2());
        assertEquals(addLibrary.getCity(), library.getCity());
        assertEquals(addLibrary.getState(), library.getState());
        assertEquals(addLibrary.getPin(), library.getPin());
        assertEquals(addLibrary.getPrimaryPhone(), library.getPrimaryPhone());
        assertEquals(addLibrary.getEmail(), library.getEmail());
        assertEquals(addLibrary.getSecondaryPhone(), library.getSecondaryPhone());
        assertEquals(addLibrary.getFax(), library.getFax());
        assertEquals(addLibrary.getCountry(), library.getCountry());
        assertEquals(addLibrary.getNetworkName(), library.getNetworkName());
        assertEquals(addLibrary.getSearchForms(), library.getSearchForms());
        assertEquals(addLibrary.getFacebookWidget(), library.getFacebookWidget());
        assertEquals(addLibrary.getTwitterWidget(), library.getTwitterWidget());
        assertEquals(addLibrary.getAboutLibrary(), library.getAboutLibrary());
        assertEquals(addLibrary.getAboutOrganization(), library.getAboutOrganization());
        assertEquals(addLibrary.getLibraryTimings(), library.getLibraryTimings());
        assertEquals(addLibrary.getContactUs(), library.getContactUs());
        assertEquals(addLibrary.getMapWidget(), library.getMapWidget());
        assertEquals(addLibrary.getDescription(), library.getDescription());
        assertEquals(addLibrary.getWebStatistics(), library.getWebStatistics());
    }
}
