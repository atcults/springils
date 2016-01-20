package org.sanelib.ils.api.converters.fiscalyear;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalyear.DeleteFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteFiscalYearConverter implements DtoToCommandConverter<FiscalYearDto> {
    public ProcessCommand convert(FiscalYearDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteFiscalYear command = new DeleteFiscalYear();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

       return command;
    }
}
