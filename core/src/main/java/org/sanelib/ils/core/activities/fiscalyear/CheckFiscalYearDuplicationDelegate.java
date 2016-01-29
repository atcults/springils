package org.sanelib.ils.core.activities.fiscalyear;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.fiscalyear.AddFiscalYear;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class CheckFiscalYearDuplicationDelegate implements JavaDelegate {

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("Checking fiscal year for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateFiscalYear;

        AddFiscalYear addFiscalYear = (AddFiscalYear) command;

        Integer libraryId = addFiscalYear.getLibraryId();

        Calendar cal = Calendar.getInstance();
        cal.setTime(addFiscalYear.getStartDate());
        Integer fiscalYearId = cal.get(Calendar.YEAR) * 10000;

        cal.setTime(addFiscalYear.getEndDate());
        fiscalYearId += cal.get(Calendar.YEAR);

        List<FiscalYear> firstFiscalYears = fiscalYearRepository.findByColumnAndValue(new String[] {"fiscalYearId.libraryId" ,"fiscalYearId.id"}, new Object[]{libraryId, fiscalYearId});

        FiscalYear dbFiscalYear = firstFiscalYears.isEmpty() ? null : firstFiscalYears.get(0);

        if(!isUpdate && dbFiscalYear != null){
            processError.addError("common.field.duplicate", "id", "domain.fiscalYear.firstFiscalYear", String.valueOf(fiscalYearId));
        }

        if (!processError.isValid()) {
            throw new AppException(processError);
        }
    }
}

