package org.sanelib.ils.api.converters.circulationMatrix;

import org.junit.Test;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.DeleteCirculationMatrix;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteCirculationMatrixConverterTest {

    @Test
    public void testDeleteCirculationMatrixSuccessExecute() throws Exception {

        CirculationMatrixDto dto = new CirculationMatrixDto();

        dto.setLibraryId("1");
        dto.setPatronCategoryId("2");
        dto.setMaterialTypeId("2");
        dto.setWithEffectFrom("2016-02-02");

        ProcessError processError = new ProcessError();

        DeleteCirculationMatrixConverter converter = new DeleteCirculationMatrixConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteCirculationMatrix);

        DeleteCirculationMatrix deleteCirculationMatrix = (DeleteCirculationMatrix) command;

        assertEquals("", dto.getLibraryId(), String .valueOf(deleteCirculationMatrix.getLibraryId()));
        assertEquals("", dto.getPatronCategoryId(), String .valueOf(deleteCirculationMatrix.getPatronCategoryId()));
        assertEquals("", dto.getMaterialTypeId(), String .valueOf(deleteCirculationMatrix.getMaterialTypeId()));
        assertEquals("", dto.getWithEffectFrom(), String .valueOf(deleteCirculationMatrix.getWithEffectFrom()));
    }
}
