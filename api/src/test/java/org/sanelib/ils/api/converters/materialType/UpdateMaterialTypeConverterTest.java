package org.sanelib.ils.api.converters.materialType;

import org.junit.Test;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.UpdateMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateMaterialTypeConverterTest {

    @Test
    public void testUpdateMaterialTypeSuccessExecute() throws Exception {

        MaterialTypeDto dto = new MaterialTypeDto();

        dto.setId("1");
        dto.setMaterialType("MicroForm");

        ProcessError processError = new ProcessError();

        UpdateMaterialTypeConverter updateMaterialTypeConverter = new UpdateMaterialTypeConverter();
        ProcessCommand command = updateMaterialTypeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateMaterialType);

        UpdateMaterialType updateMaterialType = (UpdateMaterialType) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateMaterialType.getId()));
        assertEquals("Material Type is not mapped", dto.getMaterialType(), updateMaterialType.getMaterialType());
    }
}
