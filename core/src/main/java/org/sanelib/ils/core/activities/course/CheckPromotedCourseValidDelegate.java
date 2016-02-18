package org.sanelib.ils.core.activities.course;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.commands.course.AddCourse;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckPromotedCourseValidDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking promoted course exist and not same as request course");

        Object command=execution.getVariable("command");
        ProcessError processError= (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer promotedCourseId = ((AddCourse) command).getPromotedCourseId();

        if(promotedCourseId == null){
            return;
        }

        Criteria criteria = unitOfWork.getCurrentSession().createCriteria(((ProcessCommand) command).getRootEntityClass());
        criteria.add(Restrictions.eq("courseId.id", promotedCourseId));

        List list = criteria.list();

        if(list.isEmpty()){
            processError.addError("common.field.notExist", "promotedCourseId", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.course.promotedCourseId"), String.valueOf(promotedCourseId));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
