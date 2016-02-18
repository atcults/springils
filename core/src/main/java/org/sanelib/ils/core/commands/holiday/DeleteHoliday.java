package org.sanelib.ils.core.commands.holiday;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Holiday;
import org.sanelib.ils.core.enums.HolidayType;

import java.util.Date;

public class DeleteHoliday extends ProcessCommandWithLibraryId implements ProcessCommand {

    @Override
    public Class getRootEntityClass() {
        return Holiday.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.holiday";
    }

    private Integer fiscalYearId;
    private HolidayType holidayType;
    private Date startDate;
    private Date endDate;

    public Integer getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(Integer fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

