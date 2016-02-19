package org.sanelib.ils.api.converters.course;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.DeleteCourse;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteCourseConverter implements DtoToCommandConverter<CourseDto> {

    public ProcessCommand convert(CourseDto dto, ProcessError processError)throws NoSuchFieldException,IllegalAccessException{
        DeleteCourse commad=new DeleteCourse();
        ConverterHelper.checkIdRequired(dto,commad,processError);
        ConverterHelper.checkLibraryIdRequired(dto,commad,processError);

        return commad;
    }
}
