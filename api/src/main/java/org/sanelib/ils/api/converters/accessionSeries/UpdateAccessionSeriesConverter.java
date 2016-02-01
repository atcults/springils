package org.sanelib.ils.api.converters.accessionSeries;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.commands.accessioSeries.UpdateAccessionSeries;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccessionSeriesConverter extends AddAccessionSeriesConverter {

    @Override
    public ProcessCommand convert(AccessionSeriesDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddAccessionSeries addAccessionSeries = (AddAccessionSeries) super.convert(dto, processError);

        UpdateAccessionSeries updateAccessionSeries = new UpdateAccessionSeries();

        ReflectionHelper.copy(addAccessionSeries, updateAccessionSeries);
        ConverterHelper.checkCodeRequired(dto, updateAccessionSeries, processError);

        return updateAccessionSeries;
    }
}
