package org.sanelib.ils.api.converters.library;

import org.junit.Test;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddLibraryConverterTest {

    @Test
    public void testAddLibrarySuccessExecute() throws Exception{
        LibraryDto dto = new LibraryDto();

        dto.setId("1");
        dto.setName("name");
        dto.setSerialMaster("SerialMaster");
        dto.setCatalogueMaster("CatalogueMaster");
        dto.setAcquisitionsMaster("AcquisitionMaster");
        dto.setCreatedOn("2015-12-12");
        dto.setAcquisitionStatus("AcqStatus");
        dto.setCataloguingStatus("CatStatus");
        dto.setSmStatus("SmStatus");
        dto.setHostLibraryId("100");
        dto.setAddressLine1("Address Line1");
        dto.setAddressLine2("Address Line2");
        dto.setCity("city");
        dto.setState("ST");
        dto.setPin("54321");
        dto.setPrimaryPhone("+91-9876543210");
        dto.setEmail("user@emailprovider.com");
        dto.setSecondaryPhone("+91-8976543210");
        dto.setFax("+91-9876543210");
        dto.setCountry("country");
        dto.setNetworkName("Network Name");
        dto.setSearchForms("Search Forms");
        dto.setFacebookWidget("Facebook Widget");
        dto.setTwitterWidget("Twitter Widget");
        dto.setAboutLibrary("About Library");
        dto.setAboutOrganization("About Organization");
        dto.setLibraryTimings("Library Timings");
        dto.setContactUs("Contact Us");
        dto.setMapWidget("Map Widget");
        dto.setDescription("Description");
        dto.setWebStatistics("Web Statistics");

        ProcessError processError = new ProcessError();

        AddLibraryConverter addLibraryConverter = new AddLibraryConverter();
        ProcessCommand command = addLibraryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddLibrary);

        AddLibrary addLibrary = (AddLibrary) command;

        assertEquals("Name is not mapped", dto.getName(), addLibrary.getName());
        assertEquals("Serialmaster is not mapped", dto.getSerialMaster(), addLibrary.getSerialMaster());
        assertEquals("Cataloguemaster is not mapped", dto.getCatalogueMaster(), addLibrary.getCatalogueMaster());
        assertEquals("Acquisitionmaster is not mapped", dto.getAcquisitionsMaster(), addLibrary.getAcquisitionsMaster());
        assertEquals("Created On date is not mapped", DateHelper.fromDateString(dto.getCreatedOn()), addLibrary.getCreatedOn());
        assertEquals("Acquisition status is not mapped", dto.getAcquisitionStatus(), addLibrary.getAcquisitionStatus());
        assertEquals("Cataloguing status is not mapped", dto.getCataloguingStatus(), addLibrary.getCataloguingStatus());
        assertEquals("SerialMaster status is not mapped", dto.getSmStatus(), addLibrary.getSmStatus());
        assertEquals("Host library Id is not mapped", dto.getHostLibraryId(), String.valueOf(addLibrary.getHostLibraryId()));
        assertEquals("Address Line1 is not mapped", dto.getAddressLine1(), addLibrary.getAddressLine1());
        assertEquals("Address Line2 is not mapped", dto.getAddressLine2(), addLibrary.getAddressLine2());
        assertEquals("City is not mapped", dto.getCity(), addLibrary.getCity());
        assertEquals("State is not mapped", dto.getState(), addLibrary.getState());
        assertEquals("Pin is not mapped", dto.getPin(), addLibrary.getPin());
        assertEquals("Primary Phone is not mapped", dto.getPrimaryPhone(), StringHelper.toOriginalString(addLibrary.getPrimaryPhone()));
        assertEquals("Email is not mapped", dto.getEmail(), addLibrary.getEmail());
        assertEquals("Secondary Phone is not mapped", dto.getSecondaryPhone(), StringHelper.toOriginalString(addLibrary.getSecondaryPhone()));
        assertEquals("Fax is not mapped", dto.getFax(), StringHelper.toOriginalString(addLibrary.getFax()));
        assertEquals("Country is not mapped", dto.getCountry(), addLibrary.getCountry());
        assertEquals("Network Name is not mapped", dto.getNetworkName(), addLibrary.getNetworkName());
        assertEquals("Search Form is not mapped", dto.getSearchForms(), addLibrary.getSearchForms());
        assertEquals("Facebook Widget is not mapped", dto.getFacebookWidget(), addLibrary.getFacebookWidget());
        assertEquals("Twitter Widget is not mapped", dto.getTwitterWidget(), addLibrary.getTwitterWidget());
        assertEquals("About Library Information is not mapped", dto.getAboutLibrary(), addLibrary.getAboutLibrary());
        assertEquals("About Organization Information is not mapped", dto.getAboutOrganization(), addLibrary.getAboutOrganization());
        assertEquals("Library Timing is not mapped", dto.getLibraryTimings(), addLibrary.getLibraryTimings());
        assertEquals("Contact us information is not mapped", dto.getContactUs(), addLibrary.getContactUs());
        assertEquals("Map widget is not mapped", dto.getMapWidget(), addLibrary.getMapWidget());
        assertEquals("Description is not mapped", dto.getDescription(), addLibrary.getDescription());
        assertEquals("Web statistics is not mapped", dto.getWebStatistics(), addLibrary.getWebStatistics());
    }
}
