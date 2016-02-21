package org.sanelib.ils.core.commands.circulationMatrix;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;

import java.util.Date;

public class AddCirculationMatrix extends ProcessCommandWithLibraryId implements ProcessCommand{

    @Override
    public Class getRootEntityClass() {
        return CirculationMatrix.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.circulationMatrix";
    }

    private Date withEffectFrom;
    private String loanInDays;
    private String loanInHours;
    private String loanInNextOccurrence;
    private Integer loanLimit;
    private Integer renewalLimit;
    private Double finePerDay;
    private Double maxCeilOnFine;
    private String renewalThroughOpac;
    private String otherDetails;

    public Date getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(Date withEffectFrom) {
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

    public Integer getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Integer loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Integer getRenewalLimit() {
        return renewalLimit;
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
