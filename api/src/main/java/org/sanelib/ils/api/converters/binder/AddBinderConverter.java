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

        if(Strings.isNullOrEmpty(dto.getBinderName())) {
            processError.addError("common.field.required", "name", "domain.binder.name");
        }else {
            command.setBinderName(dto.getBinderName());
        }

        command.setPrimaryAddress(dto.getPrimaryAddress());
        command.setSecondaryAddress(dto.getSecondaryAddress());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setPin(dto.getPin());

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPrimaryPhoneNumber())){
            processError.addError("common.field.pattern", "phone1", "domain.binder.phone1", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else {
            command.setPrimaryPhoneNumber(dto.getPrimaryPhoneNumber());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getSecondaryPhoneNumber())){
            processError.addError("common.field.pattern", "phone2", "domain.binder.phone2", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else{
            command.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFax())){
            processError.addError("common.field.pattern", "fax", "domain.binder.fax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        }else {
            command.setFax(dto.getFax());
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())){
            processError.addError("common.field.pattern", "email", "domain.binder.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        }else {
            command.setEmail(dto.getEmail());
        }


        return command;
    }
}
