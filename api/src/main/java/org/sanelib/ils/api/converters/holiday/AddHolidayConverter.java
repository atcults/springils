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

import java.util.Calendar;
import java.util.Objects;

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

        if(!RegularExpressionHelper.checkDateFormat(dto.getStartDate())) {
            processError.addError("common.field.pattern", "StartDate", "domain.holiday.startDate", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        }
        else{
            command.setStartDate(DateHelper.fromDateString(dto.getStartDate()));
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

        HolidayType holidayType = HolidayType.getByName(dto.getHolidayTypeName());

        if(holidayType == null){
            processError.addError("common.field.select", "holidayType", "domain.holiday.holidayType");
        }else {
            command.setHolidayType(holidayType);
        }

        command.setNote(dto.getNote());

        //create an array of days
        String[] strDays = new String[]{
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        if(Objects.equals(holidayType, HolidayType.Repeated) && command.getStartDate() != null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(command.getStartDate());
            command.setNote(strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
        }

        return command;
    }
}
