package org.sanelib.ils.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StartDateEndDateValidationDelegate implements JavaDelegate{
    @Override
    public void execute(DelegateExecution execution) throws Exception {


        Date startDate = (Date) execution.getVariable("startDate");
        Date endDate = (Date) execution.getVariable("endDate");

        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(startDate.after(endDate)){
            processError.addError("common.date.startDateAfterEndDate" , "startDate" ,"domain.date.startDate" , DateHelper.toDateString(startDate));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
