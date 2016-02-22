package org.sanelib.ils.api.converters.binderOrder;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
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

        if(Strings.isNullOrEmpty(dto.getBinderId())){
            processError.addError("common.field.required", "binderId", "domain.binderOrder.binderId");
        } else{
            command.setBinderId(Integer.parseInt(dto.getBinderId()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getOrderDate())) {
            processError.addError("common.field.pattern", "orderDate", "domain.binderOrder.orderDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setOrderDate(DateHelper.fromDateString(dto.getOrderDate()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getDueDate())) {
            processError.addError("common.field.pattern", "dueDate", "domain.binderOrder.dueDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setDueDate(DateHelper.fromDateString(dto.getDueDate()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getReturnedDate())) {
            processError.addError("common.field.pattern", "returnedDate", "domain.binderOrder.returnedDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setReturnedDate(DateHelper.fromDateString(dto.getReturnedDate()));
        }
        command.setFormLetterNo(dto.getFormLetterNo());
        command.setSubject(dto.getSubject());
        command.setContent(dto.getContent());
        command.setMailStatus(dto.isMailStatus());
        command.setPrintStatus(dto.isPrintStatus());
        command.setStatus(dto.getStatus());

        return command;
    }
}
