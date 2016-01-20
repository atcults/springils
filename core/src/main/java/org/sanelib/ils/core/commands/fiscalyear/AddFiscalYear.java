package org.sanelib.ils.core.commands.fiscalyear;

import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.FiscalYear;

import java.util.Date;

public class AddFiscalYear extends ProcessCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return FiscalYear.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.fiscalyear";
    }

    private Integer firstFiscalYear;
    private Integer secondFiscalYear;
    private Date startDate;
    private Date endDate;
    private String status;
    private String entryId;
    private Date entryDate;

    public Integer getFirstFiscalYear() {
        return firstFiscalYear;
    }

    public void setFirstFiscalYear(Integer firstFiscalYear) {
        this.firstFiscalYear = firstFiscalYear;
    }

    public Integer getSecondFiscalYear() {
        return secondFiscalYear;
    }

    public void setSecondFiscalYear(Integer secondFiscalYear) {
        this.secondFiscalYear = secondFiscalYear;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
