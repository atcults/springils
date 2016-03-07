package org.sanelib.ils.api.converters.materialType;

import org.junit.Test;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.materialType.DeleteMaterialType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DeleteMaterialTypeConverterTest {

    @Test
    public void testDeleteMaterialTypeSucessExecute() throws Throwable {
        MaterialTypeDto dto = new MaterialTypeDto();

        dto.setId("1");
        dto.setMaterialType("MicroForm");

        ProcessError processError = new ProcessError();

        DeleteMaterialTypeConverter deleteMaterialTypeConverter = new DeleteMaterialTypeConverter();
        ProcessCommand command = deleteMaterialTypeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteMaterialType);

        DeleteMaterialType deleteMaterialType = (DeleteMaterialType) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteMaterialType.getId()));
    }
}
