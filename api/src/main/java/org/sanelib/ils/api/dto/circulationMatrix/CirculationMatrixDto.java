package org.sanelib.ils.api.dto.circulationMatrix;

import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class CirculationMatrixDto implements DtoWithLibraryId {

    private String libraryId;
    private String patronCategoryId;
    private String materialTypeId;
    private String withEffectFrom;
    private String loanInDays;
    private String loanInHours;
    private String loanInNextOccurrence;
    private String loanLimit;
    private String renewalLimit;
    private String finePerDay;
    private String maxCeilOnFine;
    private String renewalThroughOpac;
    private String otherDetails;

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(String patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(String withEffectFrom) {
        this.withEffectFrom = withEffectFrom;
    }

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

    public String getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(String loanLimit) {
        this.loanLimit = loanLimit;
    }

    public String getRenewalLimit() {
        return renewalLimit;
    }

    public void setRenewalLimit(String renewalLimit) {
        this.renewalLimit = renewalLimit;
    }

    public String getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(String finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getMaxCeilOnFine() {
        return maxCeilOnFine;
    }

    public void setMaxCeilOnFine(String maxCeilOnFine) {
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

    @Override
    public String getLibraryId() {
        return libraryId;
    }
}
