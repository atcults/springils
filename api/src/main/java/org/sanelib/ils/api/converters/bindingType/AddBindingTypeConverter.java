package org.sanelib.ils.api.converters.bindingType;


import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

        if((Objects.equals(dto.getPrice(), "")) ||
                (!Strings.isNullOrEmpty(dto.getPrice()) && !RegularExpressionHelper.checkDecimal(dto.getPrice()))){
            processError.addError("common.field.invalidDouble", "price", "domain.bindingType.price");
        } else if (dto.getPrice() != null) {
            Double price = Double.parseDouble(dto.getPrice());
            if(price < 0){
                processError.addError("common.field.shouldBeGraterOrEqualThan", "price", "domain.bindingType.price");
            } else {
                command.setPrice(price);
            }
        }

        return command;
    }
}
