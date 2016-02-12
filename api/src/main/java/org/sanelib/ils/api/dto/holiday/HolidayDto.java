package org.sanelib.ils.api.dto.holiday;

import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class HolidayDto implements DtoWithLibraryId{

    private String libraryId;
    private String fiscalYearId;
    private String holidayTypeName;
    private String startDate;
    private String endDate;
    private String note;

    @Override
    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(String fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public String getHolidayType() {
        return holidayTypeName;
    }

    public void setHolidayType(String holidayTypeName) {
        this.holidayTypeName = holidayTypeName;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}