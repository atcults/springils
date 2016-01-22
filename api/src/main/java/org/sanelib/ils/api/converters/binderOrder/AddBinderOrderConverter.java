package org.sanelib.ils.api.converters.binderOrder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddBinderOrderConverter implements DtoToCommandConverter<BinderOrderDto> {

    @Override
    public ProcessCommand convert(BinderOrderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBinderOrder command = new AddBinderOrder();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        command.setBinderId(Integer.valueOf(dto.getBinderId()));
        command.setOrderDate(DateHelper.fromDateString(dto.getOrderDate()));
        command.setDueDate(DateHelper.fromDateString(dto.getDueDate()));
        command.setReturnedDate(DateHelper.fromDateString(dto.getReturnedDate()));
        command.setFormLetterNo(dto.getFormLetterNo());
        command.setSubject(dto.getSubject());
        command.setContent(dto.getContent());
        command.setMailStatus(dto.getMailStatus());
        command.setPrintStatus(dto.getPrintStatus());
        command.setStatus(dto.getStatus());
        command.setEntryId(dto.getEntryId());
        command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));


        return command;
    }
}
