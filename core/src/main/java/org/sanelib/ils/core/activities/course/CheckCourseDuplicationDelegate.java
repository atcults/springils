package org.sanelib.ils.core.activities.course;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.commands.course.UpdateCourse;
import org.sanelib.ils.core.dao.CourseRepository;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckCourseDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckCourseDuplicationDelegate.class);

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking course for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateCourse;

        Integer courseId = isUpdate ? ((UpdateCourse)command).getId() : null;
        Integer libraryId = ((AddCourse)command).getLibraryId();
        String courseName = ((AddCourse)command).getName();

        List<Course> courses = courseRepository.findByColumnAndValue(new String[] {"courseId.libraryId", "name"}, new Object[]{libraryId, courseName});

        Course dbCourse = courses.isEmpty() ? null : courses.get(0);

        if(dbCourse!=null && (!isUpdate || !Objects.equals(courseId,dbCourse.getCourseId().getId()))){
            processError.addError("common.field.duplicate", "name", Arrays.asList("domain.entity.course", "domain.common.name"), courseName);
        }

        if (!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
