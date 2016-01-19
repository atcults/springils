package org.sanelib.ils.core.activities.patronCategory;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patronCategory.UpdatePatronCategory;
import org.sanelib.ils.core.dao.PatronCategoryRepository;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.sanelib.ils.core.domain.entity.PatronCategoryId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdatePatronCategoryDelegate implements JavaDelegate {

    @Autowired
    PatronCategoryRepository patronCategoryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update Patron Category called");

        UpdatePatronCategory command = (UpdatePatronCategory) execution.getVariable("command");

        PatronCategory entity = patronCategoryRepository.get(new PatronCategoryId(command.getLibraryId(), command.getId()));

        entity.setPatronCategoryName(command.getPatronCategoryName());
        entity.setIllThruNet(command.getIllThruNet());
        entity.setRenewalThruNet(command.getRenewalThruNet());
        entity.setEntryDate(command.getEntryDate());
        entity.setOverallLoanLimit(command.getOverallLoanLimit());
        entity.setAllowMultipleCopies(command.getAllowMultipleCopies());
        entity.setAcqWorkflow(command.getAcqWorkflow());

        patronCategoryRepository.save(entity);
	}
}
