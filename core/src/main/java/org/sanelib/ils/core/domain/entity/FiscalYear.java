package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "acc_fiscal_year")
public class FiscalYear implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FiscalYearId fiscalYearId;

    @Column(name = "year1")
    private Integer firstFiscalYear;

    @Column(name = "year2")
    private Integer secondFiscalYear;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    private String status;

    @Column(name = "entry_id ")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    public FiscalYearId getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(FiscalYearId fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public void setFiscalYearId(int id, int libraryId){
        if(this.fiscalYearId == null){
            this.fiscalYearId = new FiscalYearId(libraryId, id);
        } else {
            this.fiscalYearId.setId(id);
            this.fiscalYearId.setLibraryId(libraryId);
        }
    }

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

}
