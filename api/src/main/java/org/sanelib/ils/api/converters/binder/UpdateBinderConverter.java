package org.sanelib.ils.api.converters.binder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateBinderConverter extends AddBinderConverter {

    @Override
    public ProcessCommand convert(BinderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBinder addBinder = (AddBinder) super.convert(dto, processError);

        UpdateBinder updateBinder = new UpdateBinder();
        ReflectionHelper.copy(addBinder, updateBinder);

        ConverterHelper.checkIdRequired(dto, updateBinder, processError);

        return updateBinder;
    }
}
