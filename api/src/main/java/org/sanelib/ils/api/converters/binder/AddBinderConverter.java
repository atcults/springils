package org.sanelib.ils.api.converters.binder;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddBinderConverter implements DtoToCommandConverter<BinderDto> {

    @Override
    public ProcessCommand convert(BinderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBinder command = new AddBinder();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(Strings.isNullOrEmpty(dto.getName())) {
            processError.addError("common.field.required", "name", "domain.binder.name");
        }else {
            command.setBinderName(dto.getName());
        }

        command.setPrimaryAddress(dto.getAddressLine1());
        command.setSecondaryAddress(dto.getAddressLine2());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setPin(dto.getPin());

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPrimaryPhone())){
            processError.addError("common.field.pattern", "primaryPhone", "domain.address.primaryPhone", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else {
            command.setPrimaryPhone(dto.getPrimaryPhone());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getSecondaryPhone())){
            processError.addError("common.field.pattern", "secondaryPhone", "domain.address.secondaryPhone", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else{
            command.setSecondaryPhone(dto.getSecondaryPhone());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFax())){
            processError.addError("common.field.pattern", "fax", "domain.address.fax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else {
            command.setFax(dto.getFax());
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())){
            processError.addError("common.field.pattern", "email", "domain.address.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        }else {
            command.setEmail(dto.getEmail());
        }

        return command;
    }
}
