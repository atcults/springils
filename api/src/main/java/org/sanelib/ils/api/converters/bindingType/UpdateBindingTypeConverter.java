package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.commands.bindingType.UpdateBindingType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateBindingTypeConverter extends AddBindingTypeConverter {

    @Override
    public ProcessCommand convert(BindingTypeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBindingType addBindingType = (AddBindingType) super.convert(dto, processError);

        UpdateBindingType updateBindingType = new UpdateBindingType();

        ReflectionHelper.copy(addBindingType, updateBindingType);
        ConverterHelper.checkIdRequired(dto, updateBindingType, processError);

        return updateBindingType;
    }
}
