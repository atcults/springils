package org.sanelib.ils.api.converters.binderOrder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.DeleteBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteBinderOrderConverter implements DtoToCommandConverter<BinderOrderDto> {
    public ProcessCommand convert(BinderOrderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteBinderOrder command = new DeleteBinderOrder();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        return command;
    }
}
