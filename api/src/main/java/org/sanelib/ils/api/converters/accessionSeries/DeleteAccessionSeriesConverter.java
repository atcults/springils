package org.sanelib.ils.api.converters.accessionSeries;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.DeleteAccessionSeries;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteAccessionSeriesConverter implements DtoToCommandConverter<AccessionSeriesDto> {

    public ProcessCommand convert(AccessionSeriesDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteAccessionSeries command = new DeleteAccessionSeries();

        ConverterHelper.checkCodeRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        return command;
    }
}
