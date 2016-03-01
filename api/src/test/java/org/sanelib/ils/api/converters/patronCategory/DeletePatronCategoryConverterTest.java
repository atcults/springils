package org.sanelib.ils.api.converters.patronCategory;


import org.junit.Test;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.DeletePatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeletePatronCategoryConverterTest {

    @Test
    public void testDeletePatronCategorySuccessExecute() throws Exception{

        PatronCategoryDto dto = new PatronCategoryDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError = new ProcessError();

        DeletePatronCategoryConverter converter = new DeletePatronCategoryConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeletePatronCategory);

        DeletePatronCategory deletePatronCategory = (DeletePatronCategory) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deletePatronCategory.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deletePatronCategory.getLibraryId()));
    }

}
