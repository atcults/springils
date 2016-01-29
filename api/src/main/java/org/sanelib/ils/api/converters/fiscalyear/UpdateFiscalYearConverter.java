package org.sanelib.ils.api.converters.fiscalyear;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.fiscalyear.FiscalYearDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.fiscalyear.AddFiscalYear;
import org.sanelib.ils.core.commands.fiscalyear.UpdateFiscalYear;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateFiscalYearConverter extends AddFiscalYearConverter {

    @Override
    public ProcessCommand convert(FiscalYearDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddFiscalYear addFiscalYear = (AddFiscalYear) super.convert(dto, processError);

        UpdateFiscalYear updateFiscalYear = new UpdateFiscalYear();
        ReflectionHelper.copy(addFiscalYear, updateFiscalYear);

        ConverterHelper.checkIdRequired(dto, updateFiscalYear, processError);

        return updateFiscalYear;
    }
}
