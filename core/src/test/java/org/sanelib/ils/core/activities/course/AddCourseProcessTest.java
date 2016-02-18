package org.sanelib.ils.core.activities.course;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.domain.entity.CourseId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AddCourseProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddCourseProcess() throws Throwable{
        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        Course advanceCourse = new Course();
        advanceCourse.setCourseId(hibernateHelper.getNextId(Course.class, "courseId.id"),library.getId());
        advanceCourse.setName("advance");

        persist(advanceCourse);

        persist(library);

        AddCourse addCourse = new AddCourse();

        addCourse.setLibraryId(library.getId());
        addCourse.setName("basic");
        addCourse.setEntryId("entryId");
        addCourse.setPromotedCourseId(advanceCourse.getCourseId().getId());

        String result = execute(addCourse, ActivitiProcessConstants.Admin.ADD_COURSE);
        assertNotNull(result);

        advanceCourse = fetch(Course.class, new CourseId(library.getId(), Integer.parseInt(result)));

        assertNotNull(advanceCourse);

        assertEquals(addCourse.getName(),advanceCourse.getName());
    }


}
