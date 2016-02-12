package org.sanelib.ils.api.converters.department;

import org.junit.Test;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddDepartmentConverterTest {

    @Test
    public void testAddDepartmentSuccessExecute() throws Exception{
        DepartmentDto dto = new DepartmentDto();

        dto.setLibraryId("1");
        dto.setDeptName("Department");
        dto.setHodId("1");
        ProcessError processError = new ProcessError();

        AddDepartmentConverter addDepartmentConverter = new AddDepartmentConverter();
        ProcessCommand command = addDepartmentConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddDepartment);

        AddDepartment addDepartment = (AddDepartment) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addDepartment.getLibraryId()));
        assertEquals("Name is not mapped", dto.getDeptName(), addDepartment.getDeptName());
        assertEquals("HOD Id is not mapped", dto.getHodId(), addDepartment.getHodId());
    }
}
