package org.sanelib.ils.api.converters.library;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

@Component
public class LibraryViewConverter extends AbstractViewToDtoConverterImpl<LibraryDto, LibraryView> {

    @Override
    public LibraryDto convert(LibraryView libraryView) {
        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId(String.valueOf(libraryView.getId()));
        libraryDto.setName(libraryView.getName());
        libraryDto.setSerialMaster(libraryView.getSerialMaster());
        libraryDto.setCatalogueMaster(libraryView.getCatalogueMaster());
        libraryDto.setAcquisitionsMaster(libraryView.getAcquisitionsMaster());
        libraryDto.setCreatedOn(DateHelper.toDateString(libraryView.getCreatedOn()));
        libraryDto.setAcquisitionStatus(libraryView.getAcquisitionStatus());
        libraryDto.setCataloguingStatus(libraryView.getCataloguingStatus());
        libraryDto.setSmStatus(libraryView.getSmStatus());
        libraryDto.setHostLibraryId(String.valueOf(libraryView.getHostLibraryId()));
        libraryDto.setAddressLine1(libraryView.getAddressLine1());
        libraryDto.setAddressLine2(libraryView.getAddressLine2());
        libraryDto.setCity(libraryView.getCity());
        libraryDto.setState(libraryView.getState());
        libraryDto.setPin(libraryView.getPin());
        libraryDto.setPrimaryPhone(libraryView.getPrimaryPhone());
        libraryDto.setEmail(libraryView.getEmail());
        libraryDto.setSecondaryPhone(libraryView.getSecondaryPhone());
        libraryDto.setFax(libraryView.getFax());
        libraryDto.setCountry(libraryView.getCountry());
        libraryDto.setNetworkName(libraryView.getNetworkName());
        libraryDto.setSearchForms(libraryView.getSearchForms());
        libraryDto.setFacebookWidget(libraryView.getFacebookWidget());
        libraryDto.setTwitterWidget(libraryView.getTwitterWidget());
        libraryDto.setAboutLibrary(libraryView.getAboutLibrary());
        libraryDto.setAboutOrganization(libraryView.getAboutOrganization());
        libraryDto.setLibraryTimings(libraryView.getLibraryTimings());
        libraryDto.setContactUs(libraryView.getContactUs());
        libraryDto.setMapWidget(libraryView.getMapWidget());
        libraryDto.setDescription(libraryView.getDescription());
        libraryDto.setWebStatistics(libraryView.getWebStatistics());
        
        return libraryDto;
    }
}