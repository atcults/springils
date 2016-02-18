package org.sanelib.ils.core.activities.course;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.course.UpdateCourse;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.domain.entity.CourseId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UpdateCourseProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateCourseProcess() throws Throwable{

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Course basicCourse = new Course();
        basicCourse.setCourseId(hibernateHelper.getNextId(Course.class, "courseId.id"),library.getId());
        basicCourse.setName("basic");

        persist(basicCourse);

        Course advanceCourse = new Course();
        advanceCourse.setCourseId(hibernateHelper.getNextId(Course.class, "courseId.id"),library.getId());
        advanceCourse.setName("advance");
        advanceCourse.setPromotedCourseId(basicCourse.getCourseId().getId());

        persist(advanceCourse);

        UpdateCourse updateCourse = new UpdateCourse();
        updateCourse.setId(advanceCourse.getCourseId().getId());
        updateCourse.setLibraryId(library.getId());
        updateCourse.setName("updated course");
        updateCourse.setEntryDate(DateHelper.constructDate(2016, 1, 12));
        updateCourse.setPromotedCourseId(null);

        String result = execute(updateCourse, ActivitiProcessConstants.Admin.UPDATE_COURSE);
        assertNull(result);

        Course dbCourse = fetch(Course.class, new CourseId(library.getId(), advanceCourse.getCourseId().getId()));
        assertNotNull(dbCourse);

        assertEquals(updateCourse.getName(), dbCourse.getName());

    }
}
