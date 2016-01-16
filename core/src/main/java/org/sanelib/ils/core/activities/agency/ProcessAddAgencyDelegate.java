package org.sanelib.ils.core.activities.agency;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddAgencyDelegate implements JavaDelegate {

    @Autowired
    AgencyRepository agencyRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add Agency called");

        AddAgency command = (AddAgency) execution.getVariable("command");

        Agency entity = new Agency();

        Integer nextId = agencyRepository.getNextId("agencyId.id");
        entity.setAgencyId(nextId, command.getLibraryId());
        entity.setName(command.getName());

        agencyRepository.save(entity);

        execution.setVariable("result", entity.getAgencyId().getId());
	}
}
