package org.sanelib.ils.api.converters.binder;

import org.junit.Test;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddBinderConverterTest {

    @Test
    public void testAddBinderSuccessExecute() throws Exception{
        BinderDto dto = new BinderDto();

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

        AddBinderConverter addBinderConverter = new AddBinderConverter();
        ProcessCommand command = addBinderConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddBinder);

        AddBinder addBinder = (AddBinder) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addBinder.getLibraryId()));
        assertEquals("Binder name is not mapped", dto.getName(), addBinder.getName());
        assertEquals("Primary Address is not mapped", dto.getAddressLine1(), addBinder.getPrimaryAddress());
        assertEquals("Secondary Address is not mapped", dto.getAddressLine2(), addBinder.getSecondaryAddress());
        assertEquals("City  is not mapped", dto.getCity(), addBinder.getCity());
        assertEquals("State  is not mapped", dto.getState(), addBinder.getState());
        assertEquals("Country  is not mapped", dto.getCountry(), addBinder.getCountry());
        assertEquals("Pin is not mapped", dto.getPin(), addBinder.getPin());
        assertEquals("Primary Phone Number is not mapped", dto.getPrimaryPhone(), addBinder.getPrimaryPhone());
        assertEquals("Secondary Phone Number is not mapped", dto.getSecondaryPhone(), addBinder.getSecondaryPhone());
        assertEquals("Fax is not mapped", dto.getFax(), addBinder.getFax());
        assertEquals("Email is not mapped", dto.getEmail(), addBinder.getEmail());
    }
}
