package org.sanelib.ils.api.converters.course;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddCourseConverter implements DtoToCommandConverter<CourseDto> {
    public ProcessCommand convert(CourseDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddCourse command = new AddCourse();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "courseName", "domain.common.name");
        }else{
            command.setName(dto.getName());
        }

        command.setPromotedCourseId(ConverterHelper.checkOptionalInteger("promotedCourseId", dto.getPromotedCourseId(), "domain.course.promotedCourseId", processError));

        return command;
    }
}
