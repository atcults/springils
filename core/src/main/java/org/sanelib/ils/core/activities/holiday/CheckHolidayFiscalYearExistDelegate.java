package org.sanelib.ils.core.activities.holiday;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.commands.holiday.DeleteHoliday;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckHolidayFiscalYearExistDelegate implements JavaDelegate {

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking fiscalYear with id and library id");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof ProcessCommandWithLibraryId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Integer id, libraryId;

        if(command instanceof AddHoliday){
            id = ((AddHoliday) command).getFiscalYearId();
        } else {
            id = ((DeleteHoliday) command).getFiscalYearId();
        }

        libraryId = ((ProcessCommandWithLibraryId) command).getLibraryId();

        FiscalYear fiscalYear = fiscalYearRepository.get(new FiscalYearId(libraryId, id));

        if(fiscalYear == null){
            processError.addError("common.field.notExist", "id", Arrays.asList(((ProcessCommand) command).getRootEntityName(), "domain.common.id"), String.valueOf(id));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
