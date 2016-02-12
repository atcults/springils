package org.sanelib.ils.api.converters.course;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.common.utils.DateHelper;
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
            processError.addError("common.field.required","CourseName","domain.course.name");
        }else{
            command.setName(dto.getName());
        }

        //NOTE: Default value set 0.99 in NGL.
        command.setHodId(Double.valueOf(dto.getHodId()));
        command.setEntryId(dto.getEntryId());
        command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));
        command.setpCourseId(Integer.parseInt(dto.getpCourseId()));

        return command;
    }
}
