package org.sanelib.ils.core.activities.holiday;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckHolidayEndDateIsInRangeDelegate implements JavaDelegate {

	private static final Logger LOG = LoggerFactory.getLogger(CheckHolidayEndDateIsInRangeDelegate.class);

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Autowired
    Clock clock;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Checking end date with fiscal year end date");

        Object command = execution.getVariable("command");

        if(!(command instanceof AddHoliday)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        ProcessError processError = (ProcessError) execution.getVariable("errors");

        AddHoliday addHoliday = (AddHoliday) command;

        FiscalYear fiscalYear = fiscalYearRepository.get(new FiscalYearId(addHoliday.getLibraryId(), addHoliday.getFiscalYearId()));

        if(addHoliday.getStartDate().before(clock.today())){
            processError.addError("common.holiday.startDateOutOfRange", "startDate", "domain.holiday.startDate", DateHelper.toDateString(clock.today()));
        }

        if(addHoliday.getEndDate().after(fiscalYear.getEndDate())){
            processError.addError("common.holiday.endDateOutOfRange", "endDate", "domain.holiday.endDate", DateHelper.toDateString(fiscalYear.getEndDate()));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
