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


       //Check maxNumber should not less than 0
       Integer maxNumber = Integer.valueOf(dto.getMaxNumber());
       if(maxNumber < 0) {
           processError.addError("common.field.value", "StartFromNumber", "domain.accessionSeries.maxNumber");
       }else {
           command.setMaxNumber(Integer.valueOf(dto.getMaxNumber()));
       }

       //Check maxZero should not less than 0
       Integer maxZero = Integer.valueOf(dto.getMaxZero());
       if(maxZero < 0 ){
           processError.addError("common.field.value", "MaxZero", "domain.accessionSeries.maxZero");
       }else{
           command.setMaxZero(Integer.valueOf(dto.getMaxZero()));
       }

       command.setPrefix(dto.getPrefix());

       AccessionSeriesType accessionSeriesType = AccessionSeriesType.getByName(dto.getTypeName());

       if(accessionSeriesType == null){
           processError.addError("common.field.select", "TypeName", "domain.accessionSeries.typeName");
       }else {
           command.setTypeName(accessionSeriesType);
       }

        return command;
    }
}
