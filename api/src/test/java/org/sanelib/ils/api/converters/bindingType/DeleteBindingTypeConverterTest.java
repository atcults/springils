package org.sanelib.ils.api.converters.bindingType;


import org.junit.Test;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.DeleteBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteBindingTypeConverterTest {

    @Test
    public void testDeleteBindingTypeSuccessExecute() throws Exception{

        BindingTypeDto dto = new BindingTypeDto();
        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteBindingTypeConverter converter = new DeleteBindingTypeConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteBindingType);

        DeleteBindingType deleteBindingType = (DeleteBindingType) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteBindingType.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteBindingType.getLibraryId()));
    }

}
