package org.sanelib.ils.api.converters.binderOrder;


import org.junit.Test;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.DeleteBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteBinderOrderConverterTest {

    @Test
    public void testDeleteBinderOrderSuccessExecute() throws Exception{

        BinderOrderDto dto = new BinderOrderDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteBinderOrderConverter converter = new DeleteBinderOrderConverter();
        ProcessCommand command = converter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteBinderOrder);

        DeleteBinderOrder deleteBinderOrder = (DeleteBinderOrder) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteBinderOrder.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteBinderOrder.getLibraryId()));
    }

}
