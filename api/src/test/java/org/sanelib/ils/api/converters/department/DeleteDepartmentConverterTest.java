package org.sanelib.ils.api.converters.department;

import org.junit.Test;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.DeleteDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteDepartmentConverterTest {

    @Test
    public void testDeleteDepartmentSuccessExecute() throws Exception{
        DepartmentDto dto = new DepartmentDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError = new ProcessError();

        DeleteDepartmentConverter converter = new DeleteDepartmentConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteDepartment);

        DeleteDepartment deleteDepartment = (DeleteDepartment)command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteDepartment.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteDepartment.getLibraryId()));
    }
}
