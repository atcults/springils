package org.sanelib.ils.api.dto.fiscalyear;

import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class FiscalYearDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String firstFiscalYear;
    private String secondFiscalYear;
    private String startDate;
    private String endDate;
    private String status;
    private String entryId;
    private String entryDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(String libraryId){
        this.libraryId = libraryId;
    }

    public String getFirstFiscalYear() {
        return firstFiscalYear;
    }

    public void setFirstFiscalYear(String firstFiscalYear) {
        this.firstFiscalYear = firstFiscalYear;
    }

    public String getSecondFiscalYear() {
        return secondFiscalYear;
    }

    public void setSecondFiscalYear(String secondFiscalYear) {
        this.secondFiscalYear = secondFiscalYear;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}

