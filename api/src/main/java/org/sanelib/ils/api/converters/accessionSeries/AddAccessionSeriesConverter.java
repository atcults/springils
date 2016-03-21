package org.sanelib.ils.api.converters.accessionSeries;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddAccessionSeriesConverter implements DtoToCommandConverter<AccessionSeriesDto> {

    @Override
    public ProcessCommand convert(AccessionSeriesDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddAccessionSeries command = new AddAccessionSeries();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);
        ConverterHelper.checkCodeRequired(dto, command, processError);

        AccessionSeriesType accessionSeriesType = AccessionSeriesType.getByName(dto.getAccessionSeriesType());

        //Required Series Type Value
        if (accessionSeriesType == null) {
            processError.addError("common.field.select", "accessionSeriesType", "domain.accessionSeries.accessionSeriesType");
        } else {
            command.setAccessionSeriesType(accessionSeriesType);
        }

        //Optional prefix value
        command.setPrefix(dto.getPrefix());

        //Optional positive number
        command.setMaxNumber(ConverterHelper.checkOptionalPositiveInteger("maxNumber", dto.getMaxNumber(), "domain.accessionSeries.maxNumber", 0, processError));

        //Optional positive number
        command.setMaxZero(ConverterHelper.checkOptionalPositiveInteger("maxZero", dto.getMaxZero(), "domain.accessionSeries.maxZero", 0, processError));

        return command;
    }
}
