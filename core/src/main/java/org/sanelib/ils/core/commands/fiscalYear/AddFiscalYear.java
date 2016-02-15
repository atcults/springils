package org.sanelib.ils.core.commands.fiscalYear;

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
        return "domain.entity.fiscalYear";
    }

    private Date startDate;
    private Date endDate;
    private String entryId;

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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

}
