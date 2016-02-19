package org.sanelib.ils.api.converters.bindingType;

import org.junit.Test;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddBindingTypeConverterTest {

    @Test
    public void testAddBindingTypeSuccessExecute() throws Exception{
        BindingTypeDto dto = new BindingTypeDto();

        dto.setLibraryId("1");
        dto.setBindType("BindType");
        dto.setPrice("500.00");

        ProcessError processError = new ProcessError();

        AddBindingTypeConverter addBindingTypeConverter = new AddBindingTypeConverter();
        ProcessCommand command = addBindingTypeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddBindingType);

        AddBindingType addBindingType = (AddBindingType) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addBindingType.getLibraryId()));
        assertEquals("Bind type is not mapped", dto.getBindType(), addBindingType.getBindType());
        assertEquals("Price is not mapped", Double.valueOf(dto.getPrice()), addBindingType.getPrice());

    }
}
