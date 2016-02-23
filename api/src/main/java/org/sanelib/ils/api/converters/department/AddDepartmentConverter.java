package org.sanelib.ils.api.converters.department;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddDepartmentConverter implements DtoToCommandConverter<DepartmentDto> {

    @Override
    public ProcessCommand convert(DepartmentDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddDepartment command = new AddDepartment();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        //Check name and convert
        if (Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "Department Name", "domain.department.name");
        }
        else {
            command.setName(dto.getName());
        }

        //NOTE: hodId fetch from patron
        command.setHodId(dto.getHodId());

        return command;
    }
}
