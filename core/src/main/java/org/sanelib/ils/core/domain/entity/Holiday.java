package org.sanelib.ils.core.domain.entity;

import org.sanelib.ils.core.enums.HolidayType;
import org.sanelib.ils.core.enums.HolidayTypeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "adm_co_holiday")
public class Holiday implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private HolidayId holidayId;

    @Column(name = "fiscal_year")
    private int fiscalYearId;

    @Convert(converter = HolidayTypeConverter.class)
    @Column(name = "holi_type")
    private HolidayType holidayType;

    @Column(name = "note")
    private String note;

    @Column(name="entry_id")
    private String userCode;

    @Column(name = "entry_library_id")
    private int userLibraryId;

    @Column(name = "entry_date")
    private Date entryDate;

    public HolidayId getHolidayId() {
        return this.holidayId;
    }

    private void ensureHolidayIdNotNull(){
        if (this.holidayId == null) {
            this.holidayId = new HolidayId();
        }
    }

    public void setLibraryId(int libraryId) {
        this.ensureHolidayIdNotNull();
        this.holidayId.setLibraryId(libraryId);
    }

    public void setHolidayDate(Date date) {
        this.ensureHolidayIdNotNull();
        this.holidayId.setHolidayDate(date);
    }

    public Integer getFiscalYearId() {
        return this.fiscalYearId;
    }

    public void setFiscalYearId(Integer fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public HolidayType getHolidayType() {
        return this.holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getUserLibraryId() {
        return this.userLibraryId;
    }

    public void setUserLibraryId(int userLibraryId) {
        this.userLibraryId = userLibraryId;
    }

    @PrePersist
    public void prePersist() {
        this.entryDate = new Date();
    }
}
