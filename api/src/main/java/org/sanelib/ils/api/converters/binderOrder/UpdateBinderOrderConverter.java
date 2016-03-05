package org.sanelib.ils.api.converters.binderOrder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.commands.binderOrder.UpdateBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateBinderOrderConverter extends AddBinderOrderConverter {

    @Override
    public ProcessCommand convert(BinderOrderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBinderOrder addBinderOrder = (AddBinderOrder) super.convert(dto, processError);

        UpdateBinderOrder updateBinderOrder = new UpdateBinderOrder();

        ReflectionHelper.copy(addBinderOrder, updateBinderOrder);
        ConverterHelper.checkIdRequired(dto, updateBinderOrder, processError);

        return updateBinderOrder;
    }
}
