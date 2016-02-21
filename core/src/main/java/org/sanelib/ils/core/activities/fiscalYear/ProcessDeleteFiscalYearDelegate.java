package org.sanelib.ils.core.activities.fiscalYear;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.fiscalYear.DeleteFiscalYear;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.sanelib.ils.core.domain.entity.FiscalYearId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteFiscalYearDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeleteFiscalYearDelegate.class);

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Delete FiscalYear called");

        DeleteFiscalYear command = (DeleteFiscalYear) execution.getVariable("command");
        FiscalYear fiscalYear = this.fiscalYearRepository.load(new FiscalYearId(command.getLibraryId(), command.getId()));

        fiscalYearRepository.remove(fiscalYear);
	}
}
