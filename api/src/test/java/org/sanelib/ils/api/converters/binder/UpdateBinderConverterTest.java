package org.sanelib.ils.api.converters.binder;


import org.junit.Test;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateBinderConverterTest {

    @Test
    public void testUpdateBinderSuccessExecute() throws Exception{
        BinderDto dto = new BinderDto();
        dto.setId("1");
        dto.setLibraryId("1");
        dto.setBinderName("Test Binder");
        dto.setPrimaryAddress("Primary Address");
        dto.setSecondaryAddress("Secondary Address");
        dto.setCity("TestCity");
        dto.setState("TestState");
        dto.setCountry("TestCountry");
        dto.setPin("654321");
        dto.setPrimaryPhoneNumber("+91-987654321");
        dto.setSecondaryPhoneNumber("+91-879654321");
        dto.setFax("87654321");
        dto.setEmail("user@emailprovider.com");
        dto.setEntryId("user");
        dto.setEntryDate("2015/04/01");

        ProcessError processError = new ProcessError();

        UpdateBinderConverter updateBinderConverter = new UpdateBinderConverter();
        ProcessCommand command = updateBinderConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateBinder);

        UpdateBinder updateBinder = (UpdateBinder) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateBinder.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateBinder.getLibraryId()));
        assertEquals("Binder name is not mapped", dto.getBinderName(), updateBinder.getBinderName());
        assertEquals("Primary Address is not mapped", dto.getPrimaryAddress(), updateBinder.getPrimaryAddress());
        assertEquals("Seconday Address is not mapped", dto.getSecondaryAddress(), updateBinder.getSecondaryAddress());
        assertEquals("City  is not mapped", dto.getCity(), updateBinder.getCity());
        assertEquals("State  is not mapped", dto.getState(), updateBinder.getState());
        assertEquals("Country  is not mapped", dto.getCountry(), updateBinder.getCountry());
        assertEquals("Pin is not mapped", dto.getPin(), updateBinder.getPin());
        assertEquals("Primary Phone Number is not mapped", dto.getPrimaryPhoneNumber(), updateBinder.getPrimaryPhoneNumber());
        assertEquals("Secondary Phone Number is not mapped", dto.getSecondaryPhoneNumber(), updateBinder.getSecondaryPhoneNumber());
        assertEquals("Fax is not mapped", dto.getFax(), updateBinder.getFax());
        assertEquals("Email is not mapped", dto.getEmail(), updateBinder.getEmail());
        assertEquals("Entry Id is not mapped", dto.getEntryId(), updateBinder.getEntryId());
        assertEquals("Entry Date is not mapped", dto.getEntryDate(), DateHelper.toDateString(updateBinder.getEntryDate()));
    }

}
