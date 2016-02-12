package org.sanelib.ils.api.converters.fiscalYear;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.fiscalYear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalYear.AddFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddFiscalYearConverter implements DtoToCommandConverter<FiscalYearDto> {

    @Override
    public ProcessCommand convert(FiscalYearDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddFiscalYear command = new AddFiscalYear();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(!RegularExpressionHelper.checkDateFormat(dto.getStartDate())) {
            processError.addError("common.field.pattern", "startDate", "domain.fiscalYear.startDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setStartDate(DateHelper.fromDateString(dto.getStartDate()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getEndDate())) {
            processError.addError("common.field.pattern", "endDate", "domain.fiscalYear.endDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setEndDate(DateHelper.fromDateString(dto.getEndDate()));
        }

        command.setEntryId(dto.getEntryId());

        return command;
    }
}
