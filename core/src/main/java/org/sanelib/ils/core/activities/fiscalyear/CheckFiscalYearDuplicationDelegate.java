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

import java.util.List;
import java.util.Objects;

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

        Integer fiscalYearId = isUpdate ? ((UpdateFiscalYear) command).getId() : null;
        Integer libraryId = ((AddFiscalYear) command).getLibraryId();

        //First FiscalYear Duplication Check
        Integer firstFiscalYear = ((AddFiscalYear) command).getFirstFiscalYear();

        List<FiscalYear> firstFiscalYears = fiscalYearRepository.findByColumnAndValue(new String[] {"fiscalYearId.libraryId" ,"firstFiscalYear"}, new Object[]{libraryId , firstFiscalYear});

        FiscalYear firstFiscalYearCheck = firstFiscalYears.isEmpty() ? null : firstFiscalYears.get(0);

        if (firstFiscalYearCheck != null && (!isUpdate || !Objects.equals(fiscalYearId, firstFiscalYearCheck.getFiscalYearId().getId()))) {
            processError.addError("common.field.duplicate", "firstFiscalYear", "domain.fiscalYear.firstFiscalYear", String.valueOf(firstFiscalYear));
        }

        //Second FiscalYear Duplication Check
        Integer secondFiscalYear = ((AddFiscalYear) command).getSecondFiscalYear();

        List<FiscalYear> secondFiscalYears = fiscalYearRepository.findByColumnAndValue(new String[] {"fiscalYearId.libraryId" ,"secondFiscalYear"}, new Object[]{libraryId , secondFiscalYear});

        FiscalYear secondFiscalYearCheck = secondFiscalYears.isEmpty() ? null : secondFiscalYears.get(0);

        if (secondFiscalYearCheck != null && (!isUpdate || !Objects.equals(fiscalYearId, secondFiscalYearCheck.getFiscalYearId().getId()))) {
            processError.addError("common.field.duplicate", "secondFiscalYear", "domain.fiscalYear.secondFiscalYear", String.valueOf(secondFiscalYear));
        }

        if (!processError.isValid()) {
            throw new AppException(processError);
        }
    }
}

