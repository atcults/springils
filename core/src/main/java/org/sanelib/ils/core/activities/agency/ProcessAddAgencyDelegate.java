package org.sanelib.ils.core.activities.agency;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Agency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddAgencyDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddAgencyDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    AgencyRepository agencyRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Add Agency called");

        AddAgency command = (AddAgency) execution.getVariable("command");

        Agency entity = new Agency();

        Integer nextId = hibernateHelper.getNextId(Agency.class, "agencyId.id");
        entity.setAgencyId(nextId, command.getLibraryId());
        entity.setName(command.getName());

        agencyRepository.save(entity);

        execution.setVariable("result", entity.getAgencyId().getId());
	}
}
