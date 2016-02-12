package org.sanelib.ils.core.activities.fiscalYear;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.fiscalYear.AddFiscalYear;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.FiscalYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddFiscalYearDelegate implements JavaDelegate{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("Process Add Fiscal Year Called");

        AddFiscalYear command = (AddFiscalYear) execution.getVariable("command");

        FiscalYear entity = new FiscalYear();
        entity.setLibraryId(command.getLibraryId());
        entity.setStartDate(command.getStartDate());
        entity.setEndDate(command.getEndDate());
        entity.setEntryId(command.getEntryId());

        fiscalYearRepository.save(entity);

        execution.setVariable("result", entity.getFiscalYearId().getId());

    }
}