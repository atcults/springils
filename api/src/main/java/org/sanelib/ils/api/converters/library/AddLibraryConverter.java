package org.sanelib.ils.api.converters.library;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddLibraryConverter implements DtoToCommandConverter<LibraryDto> {

    @Override
    public ProcessCommand convert(LibraryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddLibrary command = new AddLibrary();

        //Check name and convert
        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.library.name");
        } else{
            command.setName(dto.getName());
        }

        command.setSerialMaster(dto.getSerialMaster());
        command.setCatalogueMaster(dto.getCatalogueMaster());
        command.setAcquisitionsMaster(dto.getAcquisitionsMaster());

        if(!RegularExpressionHelper.checkDateFormat(dto.getCreatedOn())){
            processError.addError("common.field.pattern" , "CreatedOn" , "domain.library.createdOn" ,RegularExpressionHelper.DATE_FORMAT);
        }
        else {
            command.setCreatedOn(DateHelper.fromDateString(dto.getCreatedOn()));
        }

        command.setAcquisitionStatus(dto.getAcquisitionStatus());
        command.setCataloguingStatus(dto.getCataloguingStatus());
        command.setSmStatus(dto.getSmStatus());
        command.setHostLibraryId(Integer.valueOf(dto.getHostLibraryId()));
        command.setFirstAddress(dto.getFirstAddress());
        command.setSecondAddress(dto.getSecondAddress());
        command.setCity(dto.getCity());

        if(ConverterHelper.checkRequiredLength(dto.getState(), 2, "state", "domain.library.state", processError)){
            command.setState(dto.getState());
        }

        if(!RegularExpressionHelper.checkZipCodeFormat(dto.getPin())) {
            processError.addError("common.field.pattern", "pin", "domain.library.pin", RegularExpressionHelper.ZIP_FORMAT_EXAMPLE);
        } else {
            command.setPin(dto.getPin());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFirstPhoneNumber())) {
            processError.addError("common.field.pattern", "phone1", "domain.library.phoneNumber1", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setFirstPhoneNumber(StringHelper.convertPhoneNumber(dto.getFirstPhoneNumber()));
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())) {
            processError.addError("common.field.pattern", "email", "domain.library.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        } else {
            command.setEmail(dto.getEmail());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getSecondPhoneNumber())) {
            processError.addError("common.field.pattern", "phone2", "domain.library.phoneNumber2", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setSecondPhoneNumber(StringHelper.convertPhoneNumber(dto.getSecondPhoneNumber()));
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFax())) {
            processError.addError("common.field.pattern", "fax", "domain.library.fax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setFax(StringHelper.convertPhoneNumber(dto.getFax()));
        }

        command.setCountry(dto.getCountry());
        command.setNetworkName(dto.getNetworkName());
        command.setSearchForms(dto.getSearchForms());
        command.setFacebookWidget(dto.getFacebookWidget());
        command.setTwitterWidget(dto.getTwitterWidget());
        command.setAboutLibrary(dto.getAboutLibrary());
        command.setAboutOrganization(dto.getAboutOrganization());
        command.setLibraryTimings(dto.getLibraryTimings());
        command.setContactUs(dto.getContactUs());
        command.setMapWidget(dto.getMapWidget());
        command.setDescription(dto.getDescription());
        command.setWebStatistics(dto.getWebStatistics());

        return command;
    }
}
