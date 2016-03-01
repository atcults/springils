package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateLibraryDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateLibraryDelegate.class);

    @Autowired
    LibraryRepository libraryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Update Library called");

        UpdateLibrary command = (UpdateLibrary) execution.getVariable("command");

        Library entity = libraryRepository.get(command.getId());

        entity.setName(command.getName());
        entity.setSerialMaster(command.getSerialMaster());
        entity.setCatalogueMaster(command.getCatalogueMaster());
        entity.setAcquisitionsMaster(command.getAcquisitionsMaster());
        entity.setAddressLine1(command.getAddressLine1());
        entity.setAddressLine2(command.getAddressLine2());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setPin(command.getPin());
        entity.setPrimaryPhone(command.getPrimaryPhone());
        entity.setEmail(command.getEmail());
        entity.setSecondaryPhone(command.getSecondaryPhone());
        entity.setFax(command.getFax());
        entity.setCountry(command.getCountry());
        entity.setSearchForms(command.getSearchForms());
        entity.setFacebookWidget(command.getFacebookWidget());
        entity.setTwitterWidget(command.getTwitterWidget());
        entity.setAboutLibrary(command.getAboutLibrary());
        entity.setAboutOrganization(command.getAboutOrganization());
        entity.setLibraryTimings(command.getLibraryTimings());
        entity.setContactUs(command.getContactUs());
        entity.setMapWidget(command.getMapWidget());
        entity.setDescription(command.getDescription());
        entity.setWebStatistics(command.getWebStatistics());

        libraryRepository.save(entity);
    }
}
