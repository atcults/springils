package org.sanelib.ils.api.converters.binder;


import org.junit.Test;
import org.sanelib.ils.api.dto.binder.BinderDto;
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
        dto.setName("Test Binder");
        dto.setAddressLine1("Primary Address");
        dto.setAddressLine2("Secondary Address");
        dto.setCity("TestCity");
        dto.setState("TestState");
        dto.setCountry("TestCountry");
        dto.setPin("654321");
        dto.setPrimaryPhone("+91-9876543210");
        dto.setSecondaryPhone("+91-8796543210");
        dto.setFax("+91-9876543210");
        dto.setEmail("user@emailprovider.com");

        ProcessError processError = new ProcessError();

        UpdateBinderConverter updateBinderConverter = new UpdateBinderConverter();
        ProcessCommand command = updateBinderConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateBinder);

        UpdateBinder updateBinder = (UpdateBinder) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateBinder.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateBinder.getLibraryId()));
        assertEquals("Binder name is not mapped", dto.getName(), updateBinder.getName());
        assertEquals("Primary Address is not mapped", dto.getAddressLine1(), updateBinder.getPrimaryAddress());
        assertEquals("Seconday Address is not mapped", dto.getAddressLine2(), updateBinder.getSecondaryAddress());
        assertEquals("City  is not mapped", dto.getCity(), updateBinder.getCity());
        assertEquals("State  is not mapped", dto.getState(), updateBinder.getState());
        assertEquals("Country  is not mapped", dto.getCountry(), updateBinder.getCountry());
        assertEquals("Pin is not mapped", dto.getPin(), updateBinder.getPin());
        assertEquals("Primary Phone Number is not mapped", dto.getPrimaryPhone(), updateBinder.getPrimaryPhone());
        assertEquals("Secondary Phone Number is not mapped", dto.getSecondaryPhone(), updateBinder.getSecondaryPhone());
        assertEquals("Fax is not mapped", dto.getFax(), updateBinder.getFax());
        assertEquals("Email is not mapped", dto.getEmail(), updateBinder.getEmail());
    }
}
