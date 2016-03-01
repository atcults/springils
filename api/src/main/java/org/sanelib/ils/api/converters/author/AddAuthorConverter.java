package org.sanelib.ils.api.converters.author;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddAuthorConverter implements DtoToCommandConverter<AuthorDto> {

    @Override
    public ProcessCommand convert(AuthorDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddAuthor command = new AddAuthor();

        ConverterHelper.checkCodeRequired(dto, command, processError);

        command.setLastName(dto.getLastName());

        if(Strings.isNullOrEmpty(dto.getFirstName())){
            processError.addError("common.field.required", "firstName", "domain.author.fname");
        } else{
            command.setFirstName(dto.getFirstName());
        }


        //Check phone number and convert
        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPhone())) {
            processError.addError("common.field.pattern", "phone", "domain.author.phone", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPhone(StringHelper.convertPhoneNumber(dto.getPhone()));
        }

        command.setAddress(dto.getAddress());
        command.setCity(dto.getCity());

        //Check State should not be more than 2 characters
        if(ConverterHelper.checkRequiredLength(dto.getState(), 2, "state", "domain.author.state", processError)){
            command.setState(dto.getState());
        }

        //Check zipCode should not contain any alphabets and convert
        if(!RegularExpressionHelper.checkZipCodeFormat(dto.getZipCode())) {
            processError.addError("common.field.pattern", "zipCode", "domain.author.zip", RegularExpressionHelper.ZIP_FORMAT);
        } else {
            command.setZipCode(dto.getZipCode());
        }

        command.setContract(Boolean.parseBoolean(dto.getContract()));

        return command;
    }
}
