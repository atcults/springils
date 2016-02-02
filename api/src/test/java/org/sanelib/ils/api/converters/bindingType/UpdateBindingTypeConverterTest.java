package org.sanelib.ils.api.converters.bindingType;


import org.junit.Test;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateBindingTypeConverterTest {

    @Test
    public void testUpdateUpdateBindingTypeSuccessExecute() throws Exception{
        BindingTypeDto dto = new BindingTypeDto();
        dto.setId("1");
        dto.setLibraryId("1");
        dto.setBindType("BindType");
        dto.setPrice("500.00");
        dto.setEntryId("EntryId01");
        dto.setEntryDate("2007/01/02");

        ProcessError processError = new ProcessError();

        UpdateBindingTypeConverter updateBindingTypeConverter = new UpdateBindingTypeConverter();
        ProcessCommand command = updateBindingTypeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateBindingType);
        UpdateBindingType updateBindingType = (UpdateBindingType) command;
        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateBindingType.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateBindingType.getLibraryId()));
        assertEquals("Bind type is not mapped", dto.getBindType(), updateBindingType.getBindType());
        assertEquals("Price is not mapped", Double.valueOf(dto.getPrice()), updateBindingType.getPrice());
        assertEquals("Entry Id is not mapped", dto.getEntryId(), updateBindingType.getEntryId());
        assertEquals("Entry date is not mapped", dto.getEntryDate(), DateHelper.toDateString(updateBindingType.getEntryDate()));
    }

}
