package org.sanelib.ils.api.converters.department;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.DeleteDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteDepartmentConverter implements DtoToCommandConverter<DepartmentDto> {

    @Override
    public ProcessCommand convert(DepartmentDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteDepartment command = new DeleteDepartment();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        return command;
    }
}
