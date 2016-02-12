package org.sanelib.ils.core.activities.holiday;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.sanelib.ils.core.commands.holiday.DeleteHoliday;
import org.sanelib.ils.core.dao.HolidayRepository;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.enums.HolidayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProcessDeleteHolidayDelegate implements JavaDelegate {

    @Autowired
    HolidayRepository holidayRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        DeleteHoliday command = (DeleteHoliday) execution.getVariable("command");

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Holiday.class);
        detachedCriteria.add(Restrictions.eq("holidayId.libraryId", command.getLibraryId()));
        detachedCriteria.add(Restrictions.ge("holidayId.holidayDate", command.getStartDate()));
        detachedCriteria.add(Restrictions.lt("holidayId.holidayDate", command.getEndDate()));

        List list = this.holidayRepository.executeQueryObject(detachedCriteria, Holiday.class);

        Map<Date, Holiday> existingHolidays = new HashMap<>();

        for (Object h : list) {
            Holiday holiday = (Holiday) h;
            existingHolidays.put(holiday.getHolidayId().getHolidayDate(), holiday);
        }

        Integer removedHolidays = 0;
        int increment = command.getHolidayType() == HolidayType.Specific ? 1 : 7;

        for (LocalDate date = LocalDate.fromDateFields(command.getStartDate()); date.isBefore(LocalDate.fromDateFields(command.getEndDate()).plusDays(1)); date = date.plusDays(increment)) {
            Date currDate = date.toDate();

            if(existingHolidays.containsKey(currDate)){

                Holiday holiday = existingHolidays.get(currDate);

                if(Objects.equals(command.getHolidayType(), HolidayType.Repeated) && Objects.equals(holiday.getHolidayType(), HolidayType.Specific)){
                    continue;
                }

                holidayRepository.remove(existingHolidays.get(currDate));
                removedHolidays ++;
            }
        }

        execution.setVariable("result", removedHolidays);
    }
}
