package org.sanelib.ils.api.converters.holiday;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.enums.HolidayType;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class AddHolidayConverter implements DtoToCommandConverter<HolidayDto>{
    @Override
    public ProcessCommand convert(HolidayDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddHoliday command = new AddHoliday();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(Strings.isNullOrEmpty(String.valueOf(dto.getFiscalYearId()))){
            processError.addError("common.field.required", "fiscalYear", "domain.holiday.fiscalYearId");
        } else{
            command.setFiscalYearId(Integer.valueOf(dto.getFiscalYearId()));
        }

        Date todaysDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(todaysDate);

        cal.set( Calendar.HOUR_OF_DAY, 0 );
        cal.set( Calendar.MINUTE, 0 );
        cal.set( Calendar.SECOND, 0 );
        cal.set( Calendar.MILLISECOND, 0 );

        Date convertedDate = cal.getTime();


        if(!RegularExpressionHelper.checkDateFormat(dto.getStartDate())) {
            processError.addError("common.field.pattern", "StartDate", "domain.holiday.startDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        }
        else{
            command.setStartDate(DateHelper.fromDateString(dto.getStartDate()));
            if(command.getStartDate().before(convertedDate)){
                throw new RuntimeException("Start should be after today's date");
            }
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getEndDate())) {
            processError.addError("common.field.pattern", "EndDate", "domain.holiday.endDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        }
        else{
            command.setEndDate(DateHelper.fromDateString(dto.getEndDate()));
            if(command.getEndDate().before(command.getStartDate())){
                throw new RuntimeException("End date should be set after start date");
            }
        }

        HolidayType holidayType = HolidayType.getByValue(String.valueOf(dto.getHolidayType()));

        if(!holidayType.toString().equals("R") && !holidayType.toString().equals("S")){
            processError.addError("common.field.select", "holidayType", "domain.holiday.holidayType");
        }else {
            command.setHolidayType(holidayType);
        }

        command.setNote(dto.getNote());

        return command;
    }
}
