package org.sanelib.ils.api.converters.fiscalyear;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalyear.AddFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddFiscalYearConverter implements DtoToCommandConverter<FiscalYearDto> {

    @Override
    public ProcessCommand convert(FiscalYearDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddFiscalYear command = new AddFiscalYear();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        command.setFirstFiscalYear(Integer.valueOf(dto.getFirstFiscalYear()));
        command.setSecondFiscalYear(Integer.valueOf(dto.getSecondFiscalYear()));

        if(!RegularExpressionHelper.checkDateFormat(dto.getStartDate())) {
            processError.addError("common.field.pattern", "start_date", "domain.fiscalYear.startDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setStartDate(DateHelper.fromDateString(dto.getStartDate()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getEndDate())) {
            processError.addError("common.field.pattern", "end_date", "domain.fiscalYear.endDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setEndDate(DateHelper.fromDateString(dto.getEndDate()));
        }

        command.setStatus(dto.getStatus());
        command.setEntryId(dto.getEntryId());

        if(!RegularExpressionHelper.checkDateFormat(dto.getEntryDate())) {
            processError.addError("common.field.pattern", "entry_date", "domain.fiscalYear.entryDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));
        }

        return command;
    }
}
