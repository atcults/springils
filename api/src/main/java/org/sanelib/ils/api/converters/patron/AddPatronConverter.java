package org.sanelib.ils.api.converters.patron;


import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.AddPatron;
import org.sanelib.ils.core.enums.PatronType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddPatronConverter implements DtoToCommandConverter<PatronDto> {
    @Override
    public ProcessCommand convert(PatronDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddPatron command = new AddPatron();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);
        ConverterHelper.checkCodeRequired(dto,command , processError);

        command.setPatronCategoryId(Integer.parseInt(dto.getPatronCategoryId()));
        command.setIsOnline(dto.getIsOnline());
        command.setOwns(dto.getOwns());

        if(!RegularExpressionHelper.checkDateFormat(dto.getCreatedOn())) {
            processError.addError("common.field.pattern", "createdOn", "domain.patron.createdOn", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setCreatedOn(DateHelper.fromDateString(dto.getCreatedOn()));
        }

        command.setOtherLibraryPatronId(Integer.parseInt(dto.getOtherLibraryPatronId()));
        command.setLibraryPatronId(Integer.parseInt(dto.getLibraryPatronId()));
        command.setDeptId(Integer.parseInt(dto.getDeptId()));
        command.setFirstName(dto.getFirstName());
        command.setMiddleName(dto.getMiddleName());
        command.setLastName(dto.getLastName());
        command.setAddress1(dto.getAddress1());
        command.setAddress2(dto.getAddress2());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setPin(dto.getPin());

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPhone1())) {
            processError.addError("common.field.pattern", "phone1", "domain.patron.phone1", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPhone1(dto.getPhone1());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPhone2())) {
            processError.addError("common.field.pattern", "phone2", "domain.patron.phone2", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPhone2(dto.getPhone2());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFax())) {
            processError.addError("common.field.pattern", "fax", "domain.patron.fax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setFax(dto.getFax());
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())) {
            processError.addError("common.field.pattern", "email", "domain.patron.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        } else {
            command.setEmail(dto.getEmail());
        }

        command.setPermanentAddress1(dto.getPermanentAddress1());
        command.setPermanentAddress2(dto.getPermanentAddress2());
        command.setPermanentCity(dto.getPermanentCity());
        command.setPermanentState(dto.getPermanentState());
        command.setPermanentCountry(dto.getPermanentCountry());
        command.setPermanentPin(dto.getPermanentPin());

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPermanentPhone1())) {
            processError.addError("common.field.pattern", "permanentPhone1", "domain.patron.permanentPhone1", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPermanentPhone1(dto.getPermanentPhone1());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPermanentPhone2())) {
            processError.addError("common.field.pattern", "permanentPhone2", "domain.patron.permanentPhone2", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPermanentPhone2(dto.getPermanentPhone2());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPermanentFax())) {
            processError.addError("common.field.pattern", "permanentFax", "domain.patron.permanentFax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPermanentFax(dto.getPermanentFax());
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getPermanentEmail())) {
            processError.addError("common.field.pattern", "permanentEmail", "domain.patron.permanentEmail", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        } else {
            command.setPermanentEmail(dto.getPermanentEmail());
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getMembershipFrom())) {
            processError.addError("common.field.pattern", "membershipFrom", "domain.patron.membershipFrom", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setMembershipFrom(DateHelper.fromDateString(dto.getMembershipFrom()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getMembershipTo())) {
            processError.addError("common.field.pattern", "membershipTo", "domain.patron.membershipTo", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setMembershipTo(DateHelper.fromDateString(dto.getMembershipTo()));
        }

        command.setDelinquencyReason(dto.getDelinquencyReason());

        command.setCommonEmail(dto.commonEmail());
        command.setCommonInstantMsg(dto.commonInstantMsg());
        command.setCommonPrint(dto.commonPrint());
        command.setUserPassword(dto.getUserPassword());
        command.setCourseId(Integer.parseInt(dto.getCourseId()));
        command.setSendToAddress(dto.getSendToAddress());
        command.setCustom(dto.getCustom());
        command.setPrivilege(dto.getPrivilege());
        command.setTwitterId(dto.getTwitterId());
        command.setFacebookId(dto.getFacebookId());
        command.setSubLocationId(Integer.parseInt(dto.getSubLocationId()));
        command.setLoginId(dto.getLoginId());

        if(ConverterHelper.checkRequiredLength(dto.getAuthenticateLocalDatabase(), 1, "authenticateLocalDatabase", "domain.patron.authenticateLocalDatabase", processError)){
           command.setAuthenticateLocalDatabase(dto.getAuthenticateLocalDatabase());
       }
        PatronType patronType = PatronType.getByValue(String.valueOf(dto.getPatronType()));

        if(!patronType.toString().equals("A") && !patronType.toString().equals("B")){
            processError.addError("common.field.select", "patronType", "domain.patron.patronType");
        }else {
            command.setPatronType(patronType);
        }

        return command;
    }
}
