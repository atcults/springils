package org.sanelib.ils.api.converters.patron;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.PatronView;
import org.springframework.stereotype.Component;

@Component
public class PatronViewConverter implements ViewToDtoConverter<PatronDto, PatronView> {

    @Override
    public PatronDto convert(PatronView libraryView) {
        PatronDto dto = new PatronDto();
        dto.setLibraryId(String.valueOf(libraryView.getLibraryId()));
        dto.setCode(libraryView.getCode());
        dto.setPatronCategoryId(String.valueOf(libraryView.getPatronCategoryId()));
        dto.setIsOnline(libraryView.getIsOnline());
        dto.setOwns(libraryView.getOwns());
        dto.setCreatedOn(DateHelper.toDateString(libraryView.getCreatedOn()));
        dto.setOtherLibraryPatronId(String.valueOf(libraryView.getOtherLibraryPatronId()));
        dto.setLibraryPatronId(String.valueOf(libraryView.getLibraryPatronId()));
        dto.setDeptId(String.valueOf(libraryView.getDeptId()));
        dto.setFirstName(libraryView.getFirstName());
        dto.setMiddleName(libraryView.getMiddleName());
        dto.setLastName(libraryView.getLastName());
        dto.setAddress1(libraryView.getAddress1());
        dto.setAddress2(libraryView.getAddress2());
        dto.setCity(libraryView.getCity());
        dto.setState(libraryView.getState());
        dto.setCountry(libraryView.getCountry());
        dto.setPin(libraryView.getPin());
        dto.setPhone1(libraryView.getPhone1());
        dto.setPhone2(libraryView.getPhone2());
        dto.setFax(libraryView.getFax());
        dto.setEmail(libraryView.getEmail());
        dto.setPermanentAddress1(libraryView.getPermanentAddress1());
        dto.setPermanentAddress2(libraryView.getPermanentAddress2());
        dto.setPermanentCity(libraryView.getPermanentCity());
        dto.setPermanentState((libraryView.getPermanentState()));
        dto.setPermanentCountry(libraryView.getPermanentCountry());
        dto.setPermanentPin(libraryView.getPermanentPin());
        dto.setPermanentPhone1(libraryView.getPermanentPhone1());
        dto.setPermanentPhone2(libraryView.getPermanentPhone2());
        dto.setPermanentFax(libraryView.getPermanentFax());
        dto.setPermanentEmail(libraryView.getPermanentEmail());
        dto.setMembershipFrom(DateHelper.toDateString(libraryView.getMembershipFrom()));
        dto.setMembershipTo(DateHelper.toDateString(libraryView.getMembershipTo()));
        dto.setDelinquencyReason(libraryView.getDelinquencyReason());
        dto.setCommonEmail(libraryView.isCommonEmail());
        dto.setCommonInstantMsg(libraryView.isCommonInstantMsg());
        dto.setCommonPrint(libraryView.isCommonPrint());
        dto.setUserPassword(libraryView.getUserPassword());
        dto.setCourseId(String.valueOf(libraryView.getCourseId()));
        dto.setStatus(libraryView.getStatus());
        dto.setSendToAddress(libraryView.getSendToAddress());
        dto.setCustom(libraryView.getCustom());
        dto.setPrivilege(libraryView.getPrivilege());
        dto.setTwitterId(libraryView.getTwitterId());
        dto.setFacebookId(libraryView.getFacebookId());
        dto.setSubLocationId(String.valueOf(libraryView.getSubLocationId()));
        dto.setLoginId(libraryView.getLoginId());
        dto.setAuthenticateLocalDatabase(libraryView.getAuthenticateLocalDatabase());
        return dto;
    }
}