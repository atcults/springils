package org.sanelib.ils.api.converters.patron;


import org.junit.Test;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.AddPatron;
import org.sanelib.ils.core.enums.PatronType;
import org.sanelib.ils.core.exceptions.ProcessError;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddPatronConverterTest {

    @Test
    public void testAddPatronSuccessExecute() throws Exception {
        PatronDto dto = new PatronDto();

        dto.setLibraryId("1");
        dto.setCode("Pat1");
        dto.setPatronCategoryId("1");
        dto.setIsOnline("Is Online");
        dto.setOwns("Owns");
        dto.setCreatedOn("2014-05-02");
        dto.setOtherLibraryPatronId("1");
        dto.setLibraryPatronId("1");
        dto.setPatronType(PatronType.Patron);
        dto.setDeptId("1");
        dto.setFirstName("First Name");
        dto.setAddress1("Address1");
        dto.setAddress2("Address2");
        dto.setCity("City");
        dto.setState("State");
        dto.setCountry("Country");
        dto.setPin("387003");
        dto.setPhone1("+91-9876543210");
        dto.setPhone2("+91-9876543210");
        dto.setFax("+91-9876543210");
        dto.setEmail("name@mail.com");
        dto.setPermanentAddress1("PAddress1");
        dto.setPermanentAddress2("PAddress2");
        dto.setPermanentCity("PCity");
        dto.setPermanentState("PState");
        dto.setPermanentCountry("PCountry");
        dto.setPermanentPin("PPin");
        dto.setPermanentPhone1("+91-9876543210");
        dto.setPermanentPhone2("+91-9876543210");
        dto.setPermanentFax("+91-9876543210");
        dto.setPermanentEmail("name@mail.com");
        dto.setMembershipFrom("2014-04-01");
        dto.setMembershipTo("2016-03-31");
        dto.setDelinquencyReason("Reason");
        dto.setCommonEmail(true);
        dto.setCommonInstantMsg(true);
        dto.setCommonPrint(true);
        dto.setUserPassword("password");
        dto.setCourseId("1");
        dto.setCustom("Custom");
        dto.setPrivilege("privilege");
        dto.setTwitterId("TId");
        dto.setFacebookId("FId");
        dto.setSubLocationId("1");
        dto.setLoginId("LId");
        dto.setAuthenticateLocalDatabase("A");

        ProcessError processError = new ProcessError();

        AddPatronConverter addPatronConverter = new AddPatronConverter();
        ProcessCommand command = addPatronConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddPatron);

        AddPatron addPatron = (AddPatron) command;

        assertEquals(dto.getLibraryId(),String.valueOf(addPatron.getLibraryId()));
        assertEquals(dto.getPatronCategoryId() ,String.valueOf(addPatron.getOtherLibraryPatronId()));
        assertEquals(dto.getIsOnline() ,addPatron.getIsOnline());
        assertEquals(dto.getOwns() ,addPatron.getOwns());
        assertEquals(dto.getCreatedOn() , DateHelper.toDateString(addPatron.getCreatedOn()));
        assertEquals(dto.getOtherLibraryPatronId() ,String.valueOf(addPatron.getOtherLibraryPatronId()));
        assertEquals(dto.getPatronType() ,addPatron.getPatronType());
        assertEquals(dto.getDeptId() ,String.valueOf(addPatron.getDeptId()));
        assertEquals(dto.getFirstName() ,addPatron.getFirstName());
        assertEquals(dto.getAddress1() ,addPatron.getAddress1());
        assertEquals(dto.getAddress2() ,addPatron.getAddress2());
        assertEquals(dto.getCity() ,addPatron.getCity());
        assertEquals(dto.getState() ,addPatron.getState());
        assertEquals(dto.getCountry() ,addPatron.getCountry());
        assertEquals(dto.getPin() ,addPatron.getPin());
        assertEquals(dto.getPhone1() ,addPatron.getPhone1());
        assertEquals(dto.getPhone2() ,addPatron.getPhone2());
        assertEquals(dto.getFax() ,addPatron.getFax());
        assertEquals(dto.getEmail() ,addPatron.getEmail());
        assertEquals(dto.getPermanentAddress1() ,addPatron.getPermanentAddress1());
        assertEquals(dto.getPermanentAddress2() ,addPatron.getPermanentAddress2());
        assertEquals(dto.getPermanentCity() ,addPatron.getPermanentCity());
        assertEquals(dto.getPermanentState() ,addPatron.getPermanentState());
        assertEquals(dto.getPermanentCountry() ,addPatron.getPermanentCountry());
        assertEquals(dto.getPermanentPin() ,addPatron.getPermanentPin());
        assertEquals(dto.getPermanentPhone1() ,addPatron.getPermanentPhone1());
        assertEquals(dto.getPermanentPhone2() ,addPatron.getPermanentPhone2());
        assertEquals(dto.getPermanentFax() ,addPatron.getPermanentFax());
        assertEquals(dto.getPermanentEmail() ,addPatron.getPermanentEmail());
        assertEquals(dto.getMembershipFrom() ,DateHelper.toDateString(addPatron.getMembershipFrom()));
        assertEquals(dto.getMembershipTo() , DateHelper.toDateString(addPatron.getMembershipTo()));
        assertEquals(dto.getDelinquencyReason() ,addPatron.getDelinquencyReason());
        assertEquals(dto.commonEmail() ,addPatron.commonEmail());
        assertEquals(dto.commonInstantMsg() ,addPatron.commonInstantMsg());
        assertEquals(dto.commonPrint() ,addPatron.commonPrint());
        assertEquals(dto.getUserPassword() ,addPatron.getUserPassword());
        assertEquals(dto.getCourseId() ,String.valueOf(addPatron.getCourseId()));
        assertEquals(dto.getCustom() ,addPatron.getCustom());
        assertEquals(dto.getPrivilege() ,addPatron.getPrivilege());
        assertEquals(dto.getTwitterId() ,addPatron.getTwitterId());
        assertEquals(dto.getFacebookId() ,addPatron.getFacebookId());
        assertEquals(dto.getSubLocationId() ,String.valueOf(addPatron.getSubLocationId()));
        assertEquals(dto.getLoginId() ,addPatron.getLoginId());
        assertEquals(dto.getAuthenticateLocalDatabase() ,addPatron.getAuthenticateLocalDatabase());
    }
}
