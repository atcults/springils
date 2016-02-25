package org.sanelib.ils.core.activities.course;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.dao.CourseRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddCourseDelegate implements JavaDelegate{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Add Course called");

        AddCourse command= (AddCourse) execution.getVariable("command");

        Course entity=new Course();

        Integer nextId=hibernateHelper.getNextId(Course.class,"courseId.id");
        entity.setCourseId(nextId, command.getLibraryId());
        entity.setName(command.getName());
        entity.setEntryId(command.getUserCode());
        entity.setPromotedCourseId(command.getPromotedCourseId());

        courseRepository.save(entity);
        execution.setVariable("result", entity.getCourseId().getId());
    }
}
