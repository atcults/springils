package org.sanelib.ils.core.activities.course;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.course.UpdateCourse;
import org.sanelib.ils.core.dao.CourseRepository;
import org.sanelib.ils.core.domain.entity.Course;
import org.sanelib.ils.core.domain.entity.CourseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateCourseDelegate implements JavaDelegate{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Course called");

        UpdateCourse command = (UpdateCourse) execution.getVariable("command");

        Course entity = courseRepository.get(new CourseId(command.getLibraryId(), command.getId()));
        entity.setName(command.getName());
        entity.setEntryId(command.getUserCode());
        entity.setPromotedCourseId(command.getPromotedCourseId());

        courseRepository.save(entity);
    }
}
