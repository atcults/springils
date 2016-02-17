package org.sanelib.ils.api.converters.course;


import org.junit.Test;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.course.UpdateCourse;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateCourseConverterTest {

    @Test
    public void testUpdateCourseSuccessExecute()throws  Throwable{

        CourseDto dto=new CourseDto();
        dto.setId("1");
        dto.setLibraryId("1");
        dto.setName("name");
        dto.setHodId("10.01");
        dto.setEntryId("1");
        dto.setpCourseId("1");

        ProcessError processError=new ProcessError();
        UpdateCourseConverter updateCourseConverter= new UpdateCourseConverter();
        ProcessCommand command=updateCourseConverter.convert(dto,processError);

        assertTrue("Conversion error occurred",processError.isValid());
        assertTrue("Wrong output"+command,command instanceof UpdateCourse);

        UpdateCourse updateCourse= (UpdateCourse) command;

        assertEquals("Id is not mapped",dto.getId(),String.valueOf(updateCourse.getId()));
        assertEquals("Library id is not mapped",dto.getLibraryId(), String.valueOf(updateCourse.getLibraryId()));
        assertEquals("Name is not mapped",dto.getName(),updateCourse.getName());
        assertEquals("Hod Id not mapped",(dto.getHodId()), String.valueOf(updateCourse.getHodId()));
        assertEquals("Entry id is not mapped",dto.getEntryId(),updateCourse.getEntryId());
        assertEquals("p Course id is not mapped",dto.getpCourseId(), String.valueOf(updateCourse.getpCourseId()));
    }
}
