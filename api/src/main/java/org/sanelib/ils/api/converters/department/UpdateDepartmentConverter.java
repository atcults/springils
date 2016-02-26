package org.sanelib.ils.api.converters.department;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateDepartmentConverter extends AddDepartmentConverter {

    @Override
    public ProcessCommand convert(DepartmentDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddDepartment addDept = (AddDepartment) super.convert(dto, processError);

        UpdateDepartment updateDept = new UpdateDepartment();
        ReflectionHelper.copy(addDept, updateDept);
        ConverterHelper.checkIdRequired(dto, updateDept, processError);

        return updateDept;
    }
}
