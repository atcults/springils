package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;
import org.sanelib.ils.core.enums.HolidayType;

import java.util.Date;

public class HolidayView implements DomainView {

    private Integer libraryId;
    private Date holidayDate;
    private int fiscalYearId;
    private HolidayType holidayType;
    private String note;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public int getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(int fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "HolidayView{" +
                "libraryId=" + libraryId +
                ", holidayDate=" + holidayDate +
                ", fiscalYearId=" + fiscalYearId +
                ", holidayType=" + holidayType +
                ", note='" + note + '\'' +
                '}';
    }
}


