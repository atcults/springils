package org.sanelib.ils.api.converters.course;


import org.junit.Test;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.DeleteCourse;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteCourseConverterTest {

    @Test
    public void testDeleteCourseSuccessExecute() throws Throwable{

        CourseDto dto=new CourseDto();
        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError=new ProcessError();

        DeleteCourseConverter converter=new DeleteCourseConverter();
        ProcessCommand command=converter.convert(dto,processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output"+command, command instanceof DeleteCourse);

        DeleteCourse deleteCourse= (DeleteCourse) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteCourse.getId()));
        assertEquals("Library id is not mapped",dto.getLibraryId(),String.valueOf(deleteCourse.getLibraryId()));
    }
}
