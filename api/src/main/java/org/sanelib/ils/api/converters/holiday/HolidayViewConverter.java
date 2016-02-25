package org.sanelib.ils.api.converters.holiday;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.HolidayView;
import org.sanelib.ils.core.enums.HolidayType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HolidayViewConverter extends AbstractViewToDtoConverterImpl<HolidayDto, HolidayView> {

    @Override
    public List<HolidayDto> convert(List<HolidayView> views) {
        List<HolidayDto> holidayList = new ArrayList<>();
        HolidayView lastSpecificHoliday = null;

        HolidayView firstHoliday = null;

        Set<Date> holidayDates = new HashSet<>();

        HolidayDto specificHoliday = null;
        Map<Date, HolidayDto> dtoMap = new HashMap<>();

        for(HolidayView view : views){

            if(firstHoliday == null) {
                firstHoliday = view;
            }

            holidayDates.add(view.getHolidayDate());

            if(Objects.equals(view.getHolidayType(), HolidayType.Specific)) {

                if(lastSpecificHoliday != null && Objects.equals(lastSpecificHoliday.getNote(), view.getNote()) &&
                        Days.daysBetween(new LocalDate(lastSpecificHoliday.getHolidayDate()), new LocalDate(view.getHolidayDate())).getDays() == 1){
                    specificHoliday.setEndDate(DateHelper.toDateString(view.getHolidayDate()));
                } else {
                    specificHoliday = new HolidayDto();
                    specificHoliday.setLibraryId(String.valueOf(view.getLibraryId()));
                    specificHoliday.setFiscalYearId(String.valueOf(view.getFiscalYearId()));
                    specificHoliday.setHolidayTypeName(HolidayType.Specific.name());
                    specificHoliday.setStartDate(DateHelper.toDateString(view.getHolidayDate()));
                    specificHoliday.setEndDate(DateHelper.toDateString(view.getHolidayDate()));
                    specificHoliday.setNote(view.getNote());
                    holidayList.add(specificHoliday);
                }
                lastSpecificHoliday = view;
            } else {

                LocalDate date = LocalDate.fromDateFields(view.getHolidayDate());
                for (; date.isAfter(LocalDate.fromDateFields(firstHoliday.getHolidayDate()).minusDays(1)); date = date.minusDays(7)) {
                    if (!holidayDates.contains(date.toDate())) {
                        break;
                    }
                }

                Date startDate = date.plusDays(7).toDate();

                if(dtoMap.containsKey(startDate)){
                    dtoMap.get(startDate).setEndDate(DateHelper.toDateString(view.getHolidayDate()));
                } else{
                    HolidayDto repeatedHoliday = new HolidayDto();
                    repeatedHoliday.setLibraryId(String.valueOf(view.getLibraryId()));
                    repeatedHoliday.setFiscalYearId(String.valueOf(view.getFiscalYearId()));
                    repeatedHoliday.setHolidayTypeName(HolidayType.Repeated.name());
                    repeatedHoliday.setStartDate(DateHelper.toDateString(startDate));
                    repeatedHoliday.setEndDate(DateHelper.toDateString(view.getHolidayDate()));
                    repeatedHoliday.setNote(view.getNote());
                    holidayList.add(repeatedHoliday);
                    dtoMap.put(startDate, repeatedHoliday);
                }
            }
        }

        return holidayList;
    }
}