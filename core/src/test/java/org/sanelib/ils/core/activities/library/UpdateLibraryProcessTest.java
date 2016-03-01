package org.sanelib.ils.core.activities.library;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
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
        library.setAddressLine1("Address Line1");
        library.setAddressLine2("Address Line2");
        library.setCity("city");
        library.setState("ST");
        library.setPin("54321");
        library.setPrimaryPhone("+91-987654321");
        library.setEmail("user@emailprovider.com");
        library.setSecondaryPhone("+91-897654321");
        library.setFax("87654321");
        library.setCountry("country");
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
        updateLibrary.setAddressLine1("Updated Address Line1");
        updateLibrary.setAddressLine2("Updated Address Line2");
        updateLibrary.setCity("Updated city");
        updateLibrary.setState("ST");
        updateLibrary.setPin("54321");
        updateLibrary.setPrimaryPhone("+91-987654321");
        updateLibrary.setEmail("user@emailprovider.com");
        updateLibrary.setSecondaryPhone("+91-897654321");
        updateLibrary.setFax("87654321");
        updateLibrary.setCountry("country");
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
        assertEquals(updateLibrary.getAddressLine1(), updatedLibrary.getAddressLine1());
        assertEquals(updateLibrary.getAddressLine2(), updatedLibrary.getAddressLine2());
        assertEquals(updateLibrary.getCity(), updatedLibrary.getCity());
        assertEquals(updateLibrary.getState(), updatedLibrary.getState());
        assertEquals(updateLibrary.getPin(), updatedLibrary.getPin());
        assertEquals(updateLibrary.getPrimaryPhone(), updatedLibrary.getPrimaryPhone());
        assertEquals(updateLibrary.getEmail(), updatedLibrary.getEmail());
        assertEquals(updateLibrary.getSecondaryPhone(), updatedLibrary.getSecondaryPhone());
        assertEquals(updateLibrary.getFax(), updatedLibrary.getFax());
        assertEquals(updateLibrary.getCountry(), updatedLibrary.getCountry());
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
