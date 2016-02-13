package org.sanelib.ils.core.domain.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "acc_fiscal_year")
public class FiscalYear implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FiscalYearId fiscalYearId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "entry_id ")
    private String entryId;

    @Column(name = "year1")
    private Integer startYear;

    @Column(name = "year2")
    private Integer endYear;

    @Column(name = "status")
    String status;

    @Column(name = "entry_date")
    private Date entryDate;

    public FiscalYearId getFiscalYearId() {
        return fiscalYearId;
    }

    private void ensureFiscalIdNotNull(){
        if (this.fiscalYearId == null) {
            this.fiscalYearId = new FiscalYearId();
        }
    }

    public void setLibraryId(int libraryId) {
        ensureFiscalIdNotNull();
        this.fiscalYearId.setLibraryId(libraryId);
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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FiscalYear fiscalYear = (FiscalYear) o;

        return fiscalYearId.equals(fiscalYear.fiscalYearId);

    }

    @Override
    public int hashCode() {
        return fiscalYearId.hashCode();
    }

    @PrePersist
    public void prePersist() {
        status = "0";
        startYear = 0;
        if(startDate != null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            startYear = cal.get(Calendar.YEAR);
        }
        endYear = 0;
        if(endDate != null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(endDate);
            endYear = cal.get(Calendar.YEAR);
        }
        getFiscalYearId().setId(startYear * 10000 + endYear);
        entryDate = new Date();
    }
}


