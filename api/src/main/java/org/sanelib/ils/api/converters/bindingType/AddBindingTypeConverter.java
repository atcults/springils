package org.sanelib.ils.api.converters.bindingType;


import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddBindingTypeConverter implements DtoToCommandConverter<BindingTypeDto> {

    @Override
    public ProcessCommand convert(BindingTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBindingType command = new AddBindingType();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(Strings.isNullOrEmpty(dto.getBindType())){
            processError.addError("common.field.required", "bindType", "domain.bindingType.bindType");
        } else{
            command.setBindType(dto.getBindType());
        }

        command.setPrice(Double.parseDouble(dto.getPrice()));
        command.setEntryId(dto.getEntryId());
        command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));

        return command;
    }
}
