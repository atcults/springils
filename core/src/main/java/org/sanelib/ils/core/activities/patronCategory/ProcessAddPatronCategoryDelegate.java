package org.sanelib.ils.core.activities.patronCategory;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.PatronCategoryRepository;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddPatronCategoryDelegate implements JavaDelegate {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    PatronCategoryRepository patronCategoryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add Patron Category called");

        AddPatronCategory command = (AddPatronCategory) execution.getVariable("command");

        PatronCategory entity = new PatronCategory();

        Integer nextId = hibernateHelper.getNextId(PatronCategory.class, "patronCategoryId.id");
        entity.setPatronCategoryId(nextId, command.getLibraryId());
        entity.setPatronCategoryName(command.getPatronCategoryName());
        entity.setIllThruNet(command.getIllThruNet());
        entity.setRenewalThruNet(command.getRenewalThruNet());
        entity.setEntryDate(command.getEntryDate());
        entity.setOverallLoanLimit(command.getOverallLoanLimit());
        entity.setAllowMultipleCopies(command.getAllowMultipleCopies());
        entity.setAcqWorkflow(command.getAcqWorkflow());

        patronCategoryRepository.save(entity);

        execution.setVariable("result", entity.getPatronCategoryId().getId());
	}
}
