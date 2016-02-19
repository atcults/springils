package org.sanelib.ils.api.converters.course;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.commands.course.UpdateCourse;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateCourseConverter extends AddCourseConverter {

    @Override
    public ProcessCommand convert(CourseDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException{

        AddCourse addCourse = (AddCourse) super.convert(dto, processError);

        UpdateCourse command = new UpdateCourse();
        ReflectionHelper.copy(addCourse, command);
        ConverterHelper.checkIdRequired(dto, command, processError);

        return command;
    }
}
