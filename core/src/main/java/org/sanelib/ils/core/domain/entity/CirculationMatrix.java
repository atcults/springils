package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cir_privilage_matrix")
public class CirculationMatrix implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "library_id")
    private Integer libraryId;

    @Column(name = "patron_category_id")
    private Integer patronCategoryId;

    @Column(name = "material_type_id")
    private Integer materialTypeId;

    @Column(name = "wef")
    private Date withEffectFrom;

    @Column(name = "loan_limit")
    private Integer loanLimit;

    @Column(name = "renewal_limit")
    private Integer renewalLimit;

    @Column(name = "fine_per_day")
    private Double finePerDay;

    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "max_ceil_on_fine")
    private Double maxCeilOnFine;

    @Column(name = "renewal_through_opac")
    private String renewalThroughOpac;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Date getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(Date withEffectFrom) {
        if(Strings.isNullOrEmpty(String.valueOf(withEffectFrom)) && !this.withEffectFrom.equals(withEffectFrom)) {
            throw new IllegalStateException("The WEF must not be empty");
        }
        this.withEffectFrom = withEffectFrom;
    }

    public Integer getRenewalLimit() {
        return renewalLimit;
    }

    @Column(name = "other_details")
    private String otherDetails;

    // note : Loan periods
    // all fields as per your want for loan period.
    private String loanInDays;
    private String loanInHours;
    private String loanInNextOccurrence;

    public String getLoanInDays() {
        return loanInDays;
    }

    public void setLoanInDays(String loanInDays) {
        this.loanInDays = loanInDays;
    }

    public String getLoanInHours() {
        return loanInHours;
    }

    public void setLoanInHours(String loanInHours) {
        this.loanInHours = loanInHours;
    }

    public String getLoanInNextOccurrence() {
        return loanInNextOccurrence;
    }

    public void setLoanInNextOccurrence(String loanInNextOccurrence) {
        this.loanInNextOccurrence = loanInNextOccurrence;
    }

    public Integer getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Integer loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Integer getRenewalLimit(Integer renewalLimit) {
        return this.renewalLimit;
    }

    public void setRenewalLimit(Integer renewalLimit) {
        this.renewalLimit = renewalLimit;
    }

    public Double getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(Double finePerDay) {
        this.finePerDay = finePerDay;
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

    public Double getMaxCeilOnFine() {
        return maxCeilOnFine;
    }

    public void setMaxCeilOnFine(Double maxCeilOnFine) {
        this.maxCeilOnFine = maxCeilOnFine;
    }

    public String getRenewalThroughOpac() {
        return renewalThroughOpac;
    }

    public void setRenewalThroughOpac(String renewalThroughOpac) {
        this.renewalThroughOpac = renewalThroughOpac;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
