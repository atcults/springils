package org.sanelib.ils.api.converters.circulationMatrix;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.enums.DurationType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddCirculationMatrixConverter implements DtoToCommandConverter<CirculationMatrixDto> {

    @Override
    public ProcessCommand convert(CirculationMatrixDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddCirculationMatrix command = new AddCirculationMatrix();

        if(!RegularExpressionHelper.checkDateFormat(dto.getWithEffectFrom())) {
            processError.addError("common.field.pattern", "withEffectFrom", "domain.circulationMatrix.withEffectFrom", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        }
        else {
            command.setWithEffectFrom(DateHelper.fromDateString(dto.getWithEffectFrom()));
        }

        if(ConverterHelper.checkRequiredLength(String.valueOf(dto.getRenewalThroughOPAC()), 1, "renewalThroughOPAC", "domain.circulationMatrix.renewalThroughOPAC", processError)){
            command.setRenewalThroughOPAC(Boolean.parseBoolean(String.valueOf(dto.getRenewalThroughOPAC())));
        }

        DurationType durationType = DurationType.getByName(dto.getLoanDuration());

        if(!durationType.toString().equals("Day") && !durationType.toString().equals("Hour")) {
            processError.addError("common.field.select", "loanDurationType", "domain.circulationMatrix.loanDurationType");
        }
        else {
            command.setLoanDurationType(durationType);
        }

        if (Strings.isNullOrEmpty(dto.getLoanDuration())) {
            processError.addError("common.field.required", "loanDuration", "domain.circulationMatrix.loanDuration");
        }
        else {
            command.setLoanDuration(Integer.valueOf(dto.getLoanDuration()));
        }

        if(!durationType.toString().equals("NextOccurring")) {
            processError.addError("common.field.select", "loanDurationType", "domain.circulationMatrix.loanDurationType");
        }
        else {
           for(CirculationMatrixDto.FixedDate fixedDate : dto.getFixedDateDues()) {
               command.addFixedDateDue(Integer.valueOf(fixedDate.getDay()), Integer.valueOf(fixedDate.getMonth()));
           }
        }

        command.setIncludeHolidaysInDateDue(dto.isIncludeHolidaysInDateDue());

        if(Strings.isNullOrEmpty(dto.getOverAllLoanLimit())) {
            processError.addError("common.field.required", "overAllLoanLimit", "domain.circulationMatrix.overAllLoanLimit");
        }
        else {
            command.setOverAllLoanLimit(Integer.valueOf(dto.getOverAllLoanLimit()));
        }

        command.setRenewalLimit(Integer.valueOf(dto.getRenewalLimit()));
        command.setFinePerDay(Double.valueOf(dto.getFinePerDay()));
        command.setMaxFine(Double.valueOf(dto.getMaxCeilOnFine()));

        command.setChargeDurationType(dto.getChargeDurationType());

        if(!durationType.toString().equals("Day") && !durationType.toString().equals("Hour")) {
            processError.addError("common.field.select", "chargeDurationType", "domain.circulationMatrix.chargeDurationType");
        }
        else {
            for(CirculationMatrixDto.ChargeDetail chargeDetail : dto.getChargeDetails()) {
                command.addChargeDetail(Integer.valueOf(chargeDetail.getFrom()), Integer.valueOf(chargeDetail.getTo()), Double.valueOf(chargeDetail.getAmount()));
            }
        }

        command.setIncludeHolidaysInCharges(dto.isIncludeHolidaysInCharges());

        return command;
    }
}
