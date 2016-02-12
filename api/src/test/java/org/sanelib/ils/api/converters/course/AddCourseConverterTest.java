package org.sanelib.ils.api.converters.course;

import org.junit.Test;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCourseConverterTest {

    @Test
    public void testAddCourseSuccessExecute() throws Exception{
        CourseDto dto = new CourseDto();
        dto.setLibraryId("1");
        dto.setName("Course");
        dto.setHodId("10.01");
        dto.setEntryId("entry Id");
        dto.setEntryDate("1993/08/12");
        dto.setpCourseId("1");

        ProcessError processError = new ProcessError();

        AddCourseConverter addCourseConverter = new AddCourseConverter();
        ProcessCommand command = addCourseConverter.convert(dto,processError);

        assertTrue("Conversion error occurred",processError.isValid());
        assertTrue("Wrong Output"+command, command instanceof AddCourse);

        AddCourse addCourse= (AddCourse) command;

        assertEquals("Library Id is not mapped",dto.getLibraryId(), String.valueOf(addCourse.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), addCourse.getName());
        assertEquals("Hod Id not mapped",(dto.getHodId()), String.valueOf(addCourse.getHodId()));
        assertEquals("Entry Id is not mapped",dto.getEntryId(),addCourse.getEntryId());
        assertEquals("Entry date is not mapped",dto.getEntryDate(), DateHelper.toDateString(addCourse.getEntryDate()));
        assertEquals("p Course Id is not mapped",dto.getpCourseId(), String.valueOf(addCourse.getpCourseId()));
    }
}
