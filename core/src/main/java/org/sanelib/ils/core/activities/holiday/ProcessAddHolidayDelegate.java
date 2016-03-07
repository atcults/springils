package org.sanelib.ils.core.activities.holiday;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.sanelib.ils.core.commands.holiday.AddHoliday;
import org.sanelib.ils.core.dao.FiscalYearRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.HolidayRepository;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.enums.HolidayType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ProcessAddHolidayDelegate implements JavaDelegate {

	private static final Logger LOG = LoggerFactory.getLogger(ProcessAddHolidayDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    FiscalYearRepository fiscalYearRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process Add Holiday Called");

        AddHoliday command = (AddHoliday) execution.getVariable("command");

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Holiday.class);
        detachedCriteria.add(Restrictions.eq("holidayId.libraryId", command.getLibraryId()));
        detachedCriteria.add(Restrictions.ge("holidayId.holidayDate", command.getStartDate()));
        detachedCriteria.add(Restrictions.le("holidayId.holidayDate", command.getEndDate()));

        List list = holidayRepository.executeQueryObject(detachedCriteria);

        Map<Date, Holiday> existingHolidays = new HashMap<>();

        for(Object obj : list){
            Holiday holiday = (Holiday) obj;
            existingHolidays.put(holiday.getHolidayId().getHolidayDate(), holiday);
        }

        Integer addedHolidays = 0;
        int increment = command.getHolidayType() == HolidayType.Specific ? 1 : 7;

        for (LocalDate date = LocalDate.fromDateFields(command.getStartDate()); date.isBefore(LocalDate.fromDateFields(command.getEndDate()).plusDays(1)); date = date.plusDays(increment)) {

            Date currDate = date.toDate();

            if(!existingHolidays.containsKey(currDate)) {
                Holiday entity = new Holiday();
                entity.setLibraryId(command.getLibraryId());
                entity.setHolidayDate(currDate);
                entity.setFiscalYearId(command.getFiscalYearId());
                entity.setUserCode(command.getUserCode());
                entity.setHolidayType(command.getHolidayType());
                entity.setNote(command.getNote());
                holidayRepository.save(entity);
                addedHolidays++;
            } else if(Objects.equals(command.getHolidayType(), HolidayType.Specific)) {
                Holiday entity = existingHolidays.get(currDate);
                entity.setUserCode(command.getUserCode());
                entity.setHolidayType(command.getHolidayType());
                entity.setNote(command.getNote());
                holidayRepository.update(entity);
            }
        }

        execution.setVariable("result", addedHolidays);
    }
}
