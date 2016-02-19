package org.sanelib.ils.core.activities.agency;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.dao.AgencyRepository;
import org.sanelib.ils.core.domain.entity.Agency;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckAgencyDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckAgencyDuplicationDelegate.class);

    @Autowired
    AgencyRepository agencyRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking agency for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateAgency;

        Integer agencyId = isUpdate ? ((UpdateAgency) command).getId() : null;
        Integer libraryId = ((AddAgency) command).getLibraryId();
        String agencyName = ((AddAgency) command).getName();

        List<Agency> agencies = agencyRepository.findByColumnAndValue(new String[]{"agencyId.libraryId", "name"}, new Object[] {libraryId, agencyName});

        Agency dbAgency = agencies.isEmpty() ? null : agencies.get(0);

        if(dbAgency != null && (!isUpdate || !Objects.equals(agencyId, dbAgency.getAgencyId().getId()))){
            processError.addError("common.field.duplicate", "name", Arrays.asList("domain.entity.library", "domain.agency.name"), agencyName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
