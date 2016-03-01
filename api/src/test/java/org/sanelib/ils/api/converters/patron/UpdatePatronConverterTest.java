package org.sanelib.ils.api.converters.patron;


import org.junit.Test;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.UpdatePatron;
import org.sanelib.ils.core.enums.PatronType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdatePatronConverterTest {

    @Test
    public void testUpdatePatronSuccessExecute() throws Exception {

        PatronDto dto = new PatronDto();

        dto.setLibraryId("1");
        dto.setCode("Pat2");
        dto.setPatronCategoryId("1");
        dto.setOwns("Owns");
        dto.setOtherLibraryPatronId("1");
        dto.setLibraryPatronId("1");
        dto.setPatronType(PatronType.Patron);
        dto.setDeptId("1");
        dto.setFirstName("First Name");
        dto.setAddress1("Address1");
        dto.setAddress2("Address2");
        dto.setCity("City2");
        dto.setState("State2");
        dto.setCountry("Country2");
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
        dto.setSendToAddress(true);
        dto.setActive(true);

        ProcessError processError = new ProcessError();

        UpdatePatronConverter updatePatronConverter = new UpdatePatronConverter();
        ProcessCommand command = updatePatronConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdatePatron);

        UpdatePatron updatePatron = (UpdatePatron) command;

        assertEquals(dto.getLibraryId(),String.valueOf(updatePatron.getLibraryId()));
        assertEquals(dto.getPatronCategoryId(), String.valueOf(updatePatron.getOtherLibraryPatronId()));
        assertEquals(dto.getOwns(), updatePatron.getOwns());
        assertEquals(dto.getOtherLibraryPatronId(), String.valueOf(updatePatron.getOtherLibraryPatronId()));
        assertEquals(dto.getPatronType(), updatePatron.getPatronType());
        assertEquals(dto.getDeptId(), String.valueOf(updatePatron.getDeptId()));
        assertEquals(dto.getFirstName(), updatePatron.getFirstName());
        assertEquals(dto.getAddress1(), updatePatron.getAddressLine1());
        assertEquals(dto.getAddress2(), updatePatron.getAddressLine2());
        assertEquals(dto.getCity(), updatePatron.getCity());
        assertEquals(dto.getState(), updatePatron.getState());
        assertEquals(dto.getCountry(), updatePatron.getCountry());
        assertEquals(dto.getPin(), updatePatron.getPin());
        assertEquals(dto.getPhone1(), updatePatron.getPhone1());
        assertEquals(dto.getPhone2(), updatePatron.getPhone2());
        assertEquals(dto.getFax(), updatePatron.getFax());
        assertEquals(dto.getEmail(), updatePatron.getEmail());
        assertEquals(dto.getPermanentAddress1(), updatePatron.getPermanentAddressLine1());
        assertEquals(dto.getPermanentAddress2(), updatePatron.getPermanentAddressLine2());
        assertEquals(dto.getPermanentCity(), updatePatron.getPermanentCity());
        assertEquals(dto.getPermanentState(), updatePatron.getPermanentState());
        assertEquals(dto.getPermanentCountry(), updatePatron.getPermanentCountry());
        assertEquals(dto.getPermanentPin(), updatePatron.getPermanentPin());
        assertEquals(dto.getPermanentPhone1(), updatePatron.getPermanentPhone1());
        assertEquals(dto.getPermanentPhone2(), updatePatron.getPermanentPhone2());
        assertEquals(dto.getPermanentFax(), updatePatron.getPermanentFax());
        assertEquals(dto.getPermanentEmail(), updatePatron.getPermanentEmail());
        assertEquals(dto.getMembershipFrom(), DateHelper.toDateString(updatePatron.getMembershipFrom()));
        assertEquals(dto.getMembershipTo(),  DateHelper.toDateString(updatePatron.getMembershipTo()));
        assertEquals(dto.getDelinquencyReason(), updatePatron.getDelinquencyReason());
        assertEquals(dto.commonEmail(), updatePatron.commonEmail());
        assertEquals(dto.commonInstantMsg(), updatePatron.commonInstantMsg());
        assertEquals(dto.commonPrint(), updatePatron.commonPrint());
        assertEquals(dto.getUserPassword(), updatePatron.getUserPassword());
        assertEquals(dto.getCourseId(), String.valueOf(updatePatron.getCourseId()));
        assertEquals(dto.getCustom(), updatePatron.getCustom());
        assertEquals(dto.getPrivilege(), updatePatron.getPrivilege());
        assertEquals(dto.getTwitterId(), updatePatron.getTwitterId());
        assertEquals(dto.getFacebookId(), updatePatron.getFacebookId());
        assertEquals(dto.getSubLocationId(), String.valueOf(updatePatron.getSubLocationId()));
        assertEquals(dto.getLoginId(), updatePatron.getLoginId());
        assertEquals(dto.getAuthenticateLocalDatabase(), updatePatron.getAuthenticateLocalDatabase());
        assertEquals(dto.isSendToAddress(), updatePatron.isSendToAddress());
        assertEquals(dto.isActive(), updatePatron.isActive());
    }
}
