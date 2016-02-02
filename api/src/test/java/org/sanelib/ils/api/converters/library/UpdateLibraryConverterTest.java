package org.sanelib.ils.api.converters.library;


import org.junit.Test;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateLibraryConverterTest {

    @Test
    public void testUpdateLibrarySuccessExecute() throws Exception{
        LibraryDto dto = new LibraryDto();

        dto.setId("1");
        dto.setName("name");
        dto.setSerialMaster("SerialMaster");
        dto.setCatalogueMaster("CatalogueMaster");
        dto.setAcquisitionsMaster("AcquisitionMaster");
        dto.setCreatedOn("2015/12/12");
        dto.setAcquisitionStatus("AcqStatus");
        dto.setCataloguingStatus("CatStatus");
        dto.setSmStatus("SmStatus");
        dto.setHostLibraryId("100");
        dto.setFirstAddress("FirstAddress");
        dto.setSecondAddress("SecondAddress");
        dto.setCity("city");
        dto.setState("ST");
        dto.setPin("54321");
        dto.setFirstPhoneNumber("+91-9876543210");
        dto.setEmail("user@emailprovider.com");
        dto.setSecondPhoneNumber("+91-8976543210");
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

        UpdateLibraryConverter updateLibraryConverter = new UpdateLibraryConverter();
        ProcessCommand command = updateLibraryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateLibrary);

        UpdateLibrary updateLibrary = (UpdateLibrary) command;

        assertEquals("Name is not mapped", dto.getName(), updateLibrary.getName());
        assertEquals("Serialmaster is not mapped", dto.getSerialMaster(), updateLibrary.getSerialMaster());
        assertEquals("Cataloguemaster is not mapped", dto.getCatalogueMaster(), updateLibrary.getCatalogueMaster());
        assertEquals("Acquisitionmaster is not mapped", dto.getAcquisitionsMaster(), updateLibrary.getAcquisitionsMaster());
        assertEquals("Created On date is not mapped", DateHelper.fromDateString(dto.getCreatedOn()), updateLibrary.getCreatedOn());
        assertEquals("Acquisition status is not mapped", dto.getAcquisitionStatus(), updateLibrary.getAcquisitionStatus());
        assertEquals("Cataloguing status is not mapped", dto.getCataloguingStatus(), updateLibrary.getCataloguingStatus());
        assertEquals("SerialMaster status is not mapped", dto.getSmStatus(), updateLibrary.getSmStatus());
        assertEquals("Host library Id is not mapped", dto.getHostLibraryId(), String.valueOf(updateLibrary.getHostLibraryId()));
        assertEquals("First Address is not mapped", dto.getFirstAddress(), updateLibrary.getFirstAddress());
        assertEquals("Second Address is not mapped", dto.getSecondAddress(), updateLibrary.getSecondAddress());
        assertEquals("City is not mapped", dto.getCity(), updateLibrary.getCity());
        assertEquals("State is not mapped", dto.getState(), updateLibrary.getState());
        assertEquals("Pin is not mapped", dto.getPin(), updateLibrary.getPin());
        assertEquals("First Phone number is not mapped", dto.getFirstPhoneNumber(), StringHelper.toOriginalString(updateLibrary.getFirstPhoneNumber()));
        assertEquals("Email is not mapped", dto.getEmail(), updateLibrary.getEmail());
        assertEquals("Second Phone number is not mapped", dto.getSecondPhoneNumber(), StringHelper.toOriginalString(updateLibrary.getSecondPhoneNumber()));
        assertEquals("Fax is not mapped", dto.getFax(), StringHelper.toOriginalString(updateLibrary.getFax()));
        assertEquals("Country is not mapped", dto.getCountry(), updateLibrary.getCountry());
        assertEquals("Network Name is not mapped", dto.getNetworkName(), updateLibrary.getNetworkName());
        assertEquals("Search Form is not mapped", dto.getSearchForms(), updateLibrary.getSearchForms());
        assertEquals("Facebook Widget is not mapped", dto.getFacebookWidget(), updateLibrary.getFacebookWidget());
        assertEquals("Twitter Widget is not mapped", dto.getTwitterWidget(), updateLibrary.getTwitterWidget());
        assertEquals("About Library Information is not mapped", dto.getAboutLibrary(), updateLibrary.getAboutLibrary());
        assertEquals("About Organization Information is not mapped", dto.getAboutOrganization(), updateLibrary.getAboutOrganization());
        assertEquals("Library Timing is not mapped", dto.getLibraryTimings(), updateLibrary.getLibraryTimings());
        assertEquals("Contact us information is not mapped", dto.getContactUs(), updateLibrary.getContactUs());
        assertEquals("Map widget is not mapped", dto.getMapWidget(), updateLibrary.getMapWidget());
        assertEquals("Description is not mapped", dto.getDescription(), updateLibrary.getDescription());
        assertEquals("Web statistics is not mapped", dto.getWebStatistics(), updateLibrary.getWebStatistics());


    }

}
