package org.sanelib.ils.core.activities.course;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.course.DeleteCourse;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.domain.entity.CourseId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteCourseProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteCourseProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Course course = new Course();
        course.setCourseId(hibernateHelper.getNextId(Course.class,"courseId.id"), library.getId());
        course.setName("course");

        persist(course);

        DeleteCourse deleteCourse=new DeleteCourse();
        deleteCourse.setId(course.getCourseId().getId());
        deleteCourse.setLibraryId(library.getId());

        String result = execute(deleteCourse, ActivitiProcessConstants.Admin.DELETE_COURSE);
        assertNull(result);

        Course dbCourse = fetch(Course.class, new CourseId(library.getId(), course.getCourseId().getId()));
        assertNull(dbCourse);
    }
}
