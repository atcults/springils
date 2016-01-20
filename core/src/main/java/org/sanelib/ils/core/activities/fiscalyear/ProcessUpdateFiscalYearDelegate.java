package org.sanelib.ils.core.activities.fiscalyear;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateFiscalYearDelegate implements JavaDelegate {

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update FiscalYear called");

        UpdateFiscalYear command = (UpdateFiscalYear) execution.getVariable("command");

        FiscalYear entity = fiscalYearRepository.get(new FiscalYearId(command.getLibraryId(), command.getId()));

        entity.setFirstFiscalYear(command.getFirstFiscalYear());
        entity.setSecondFiscalYear(command.getSecondFiscalYear());
        entity.setStartDate(command.getStartDate());
        entity.setEndDate(command.getEndDate());
        entity.setEntryId(command.getEntryId());
        entity.setEntryDate(command.getEntryDate());

        fiscalYearRepository.save(entity);
	}
}
