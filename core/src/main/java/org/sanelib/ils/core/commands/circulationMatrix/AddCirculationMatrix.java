package org.sanelib.ils.core.commands.circulationMatrix;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.enums.DurationType;

import java.util.Date;
import java.util.List;

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
    private Integer overAllLoanLimit;
    private Integer renewalLimit;
    private Double finePerDay;
    private Double maxCeilOnFine;
    private String renewalThroughOPAC;
    private String otherDetails;
    private String auditUserCode;
    private DurationType loanDurationType;
    private Integer loanDuration;
    private boolean includeHolidaysInDateDue;
    private List fixedDateDues;
    private DurationType chargeDurationType;
    private boolean includeHolidaysInCharges;
    private Integer day;
    private Integer month;
    private Integer from;
    private Integer to;
    private Double amount;

    public Date getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(Date withEffectFrom) {
        this.withEffectFrom = withEffectFrom;
    }

    public Integer getOverAllLoanLimit() {
        return overAllLoanLimit;
    }

    public void setOverAllLoanLimit(Integer overAllLoanLimit) {
        this.overAllLoanLimit = overAllLoanLimit;
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

    public boolean getRenewalThroughOPAC() {
        return Boolean.parseBoolean(renewalThroughOPAC);
    }

    public void setRenewalThroughOPAC(boolean renewalThroughOPAC) {
        this.renewalThroughOPAC = String.valueOf(renewalThroughOPAC);
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getAuditUserCode() {
        return auditUserCode;
    }

    public void setAuditUserCode(String auditUserCode) {
        this.auditUserCode = auditUserCode;
    }

    public DurationType getLoanDurationType() {
        return loanDurationType;
    }

    public void setLoanDurationType(DurationType loanDurationType) {
        this.loanDurationType = loanDurationType;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public boolean isIncludeHolidaysInDateDue() {
        return includeHolidaysInDateDue;
    }

    public void setIncludeHolidaysInDateDue(boolean includeHolidaysInDateDue) {
        this.includeHolidaysInDateDue = includeHolidaysInDateDue;
    }

    public List getFixedDateDues() {
        return fixedDateDues;
    }

    public void setFixedDateDues(List fixedDateDues) {
        this.fixedDateDues = fixedDateDues;
    }

    public DurationType getChargeDurationType() {
        return chargeDurationType;
    }

    public void setChargeDurationType(DurationType chargeDurationType) {
        this.chargeDurationType = chargeDurationType;
    }

    public boolean isIncludeHolidaysInCharges() {
        return includeHolidaysInCharges;
    }

    public void setIncludeHolidaysInCharges(boolean includeHolidaysInCharges) {
        this.includeHolidaysInCharges = includeHolidaysInCharges;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
