package org.sanelib.ils.api.converters.library;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

@Component
public class LibraryViewConverter implements ViewToDtoConverter<LibraryDto, LibraryView> {

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
        libraryDto.setFirstAddress(libraryView.getFirstAddress());
        libraryDto.setSecondAddress(libraryView.getSecondAddress());
        libraryDto.setCity(libraryView.getCity());
        libraryDto.setState(libraryView.getState());
        libraryDto.setPin(libraryView.getPin());
        libraryDto.setFirstPhoneNumber(libraryView.getFirstPhoneNumber());
        libraryDto.setEmail(libraryView.getEmail());
        libraryDto.setSecondPhoneNumber(libraryView.getSecondPhoneNumber());
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