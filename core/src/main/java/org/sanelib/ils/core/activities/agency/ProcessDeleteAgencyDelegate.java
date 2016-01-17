package org.sanelib.ils.core.activities.agency;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.agency.DeleteAgency;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.AgencyId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteAgencyDelegate implements JavaDelegate {

    @Autowired
    AgencyRepository agencyRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Delete Agency called");

        DeleteAgency command = (DeleteAgency) execution.getVariable("command");
        Agency agency = this.agencyRepository.load(new AgencyId(command.getLibraryId(), command.getId()));
        agencyRepository.remove(agency);
	}
}
