package org.sanelib.ils.core.activities.agency;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.AgencyId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateAgencyDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateAgencyDelegate.class);

    @Autowired
    AgencyRepository agencyRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Update Agency called");

        UpdateAgency command = (UpdateAgency) execution.getVariable("command");

        Agency entity = agencyRepository.get(new AgencyId(command.getLibraryId(), command.getId()));

        entity.setName(command.getName());

        agencyRepository.save(entity);
	}
}
