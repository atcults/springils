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

       command.setMaxNumber(Integer.valueOf(dto.getMaxNumber()));
       command.setMaxZero(Integer.valueOf(dto.getMaxZero()));
       command.setPrefix(dto.getPrefix());

       AccessionSeriesType accessionSeriesType = AccessionSeriesType.getByValue(String.valueOf(dto.getTypeName()));

       if(!accessionSeriesType.toString().equals("A") && !accessionSeriesType.toString().equals("B")){
           processError.addError("common.field.select", "TypeName", "domain.accessionSeries.typeName");
       }else {
           command.setTypeName(accessionSeriesType);
       }

        return command;
    }
}
