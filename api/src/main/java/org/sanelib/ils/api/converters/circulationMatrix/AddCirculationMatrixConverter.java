package org.sanelib.ils.api.converters.circulationMatrix;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddCirculationMatrixConverter implements DtoToCommandConverter<CirculationMatrixDto> {

    @Override
    public ProcessCommand convert(CirculationMatrixDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddCirculationMatrix command = new AddCirculationMatrix();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        command.setWithEffectFrom(DateHelper.fromDateString(dto.getWithEffectFrom()));
        command.setLoanLimit(Integer.valueOf(dto.getLoanLimit()));
        command.setRenewalLimit(Integer.valueOf(dto.getRenewalLimit()));
        command.setFinePerDay(Double.valueOf(dto.getFinePerDay()));
        command.setMaxCeilOnFine(Double.valueOf(dto.getMaxCeilOnFine()));
        command.setRenewalThroughOpac(dto.getRenewalThroughOpac());
        command.setOtherDetails(dto.getOtherDetails());

        return command;
    }
}
