package org.sanelib.ils.core.activities.course;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.course.DeleteCourse;
import org.sanelib.ils.core.dao.CourseRepository;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.domain.entity.CourseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteCourseDelegate implements JavaDelegate {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Delete Course called");

        DeleteCourse command= (DeleteCourse) execution.getVariable("command");
        Course course=this.courseRepository.load(new CourseId(command.getLibraryId(), command.getId()));
        courseRepository.remove(course);
    }
}
