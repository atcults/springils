package org.sanelib.ils.api.converters.patron;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.PatronView;
import org.springframework.stereotype.Component;

@Component
public class PatronViewConverter extends AbstractViewToDtoConverterImpl<PatronDto, PatronView> {

    @Override
    public PatronDto convert(PatronView patronView) {
        PatronDto dto = new PatronDto();

        dto.setLibraryId(String.valueOf(patronView.getLibraryId()));
        dto.setCode(patronView.getCode());
        dto.setPatronCategoryId(String.valueOf(patronView.getPatronCategoryId()));
        dto.setIsOnline(patronView.getIsOnline());
        dto.setOwns(patronView.getOwns());
        dto.setOtherLibraryPatronId(String.valueOf(patronView.getOtherLibraryPatronId()));
        dto.setLibraryPatronId(String.valueOf(patronView.getLibraryPatronId()));
        dto.setPatronType(patronView.getPatronType());
        dto.setDeptId(String.valueOf(patronView.getDeptId()));
        dto.setFirstName(patronView.getFirstName());
        dto.setMiddleName(patronView.getMiddleName());
        dto.setLastName(patronView.getLastName());
        dto.setAddress1(patronView.getAddress1());
        dto.setAddress2(patronView.getAddress2());
        dto.setCity(patronView.getCity());
        dto.setState(patronView.getState());
        dto.setCountry(patronView.getCountry());
        dto.setPin(patronView.getPin());
        dto.setPhone1(patronView.getPhone1());
        dto.setPhone2(patronView.getPhone2());
        dto.setFax(patronView.getFax());
        dto.setEmail(patronView.getEmail());
        dto.setPermanentAddress1(patronView.getPermanentAddress1());
        dto.setPermanentAddress2(patronView.getPermanentAddress2());
        dto.setPermanentCity(patronView.getPermanentCity());
        dto.setPermanentState((patronView.getPermanentState()));
        dto.setPermanentCountry(patronView.getPermanentCountry());
        dto.setPermanentPin(patronView.getPermanentPin());
        dto.setPermanentPhone1(patronView.getPermanentPhone1());
        dto.setPermanentPhone2(patronView.getPermanentPhone2());
        dto.setPermanentFax(patronView.getPermanentFax());
        dto.setPermanentEmail(patronView.getPermanentEmail());
        dto.setMembershipFrom(DateHelper.toDateString(patronView.getMembershipFrom()));
        dto.setMembershipTo(DateHelper.toDateString(patronView.getMembershipTo()));
        dto.setDelinquencyReason(patronView.getDelinquencyReason());
        dto.setCommonEmail(patronView.isCommonEmail());
        dto.setCommonInstantMsg(patronView.isCommonInstantMsg());
        dto.setCommonPrint(patronView.isCommonPrint());
        dto.setEntryDate(DateHelper.toDateString(patronView.getEntryDate()));
        dto.setUserPassword(patronView.getUserPassword());
        dto.setCourseId(String.valueOf(patronView.getCourseId()));
        dto.setStatus(patronView.getStatus());
        dto.setSendToAddress(patronView.getSendToAddress());
        dto.setCustom(patronView.getCustom());
        dto.setPrivilege(patronView.getPrivilege());
        dto.setTwitterId(patronView.getTwitterId());
        dto.setFacebookId(patronView.getFacebookId());
        dto.setSubLocationId(String.valueOf(patronView.getSubLocationId()));
        dto.setLoginId(patronView.getLoginId());
        dto.setAuthenticateLocalDatabase(patronView.getAuthenticateLocalDatabase());

        return dto;
    }
}