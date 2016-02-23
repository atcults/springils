package org.sanelib.ils.api.converters.materialType;

import org.junit.Test;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddMaterialTypeConverterTest {

    @Test
    public void testAddMaterialTypeSuccessExecute() throws Exception {

        MaterialTypeDto dto = new MaterialTypeDto();

        dto.setId("1");
        dto.setMaterialType("MicroForm");

        ProcessError processError = new ProcessError();

        AddMaterialTypeConverter addMaterialTypeConverter = new AddMaterialTypeConverter();
        ProcessCommand command = addMaterialTypeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddMaterialType);

        AddMaterialType addMaterialType = (AddMaterialType) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(addMaterialType.getId()));
        assertEquals("Material Type is not mapped", dto.getMaterialType(), addMaterialType.getMaterialType());
    }
}
