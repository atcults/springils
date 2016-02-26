package org.sanelib.ils.api.converters.department;

import org.junit.Test;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateDepartmentConverterTest {

    @Test
    public void testUpdateDepartmentSuccessExecute() throws Exception{
        DepartmentDto dto = new DepartmentDto();

        dto.setId("1");
        dto.setLibraryId("1");
        dto.setName("Department Changed.");

        ProcessError processError = new ProcessError();

        UpdateDepartmentConverter updateDepartmentConverter = new UpdateDepartmentConverter();
        ProcessCommand command = updateDepartmentConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateDepartment);

        UpdateDepartment updateDepartment = (UpdateDepartment)command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateDepartment.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateDepartment.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), updateDepartment.getName());
    }
}
