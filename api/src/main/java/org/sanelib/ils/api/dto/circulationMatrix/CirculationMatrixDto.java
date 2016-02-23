package org.sanelib.ils.api.dto.circulationMatrix;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.mapping.List;
import org.sanelib.ils.api.dto.DtoWithLibraryId;
import org.sanelib.ils.core.enums.DurationType;

public class CirculationMatrixDto implements DtoWithLibraryId {

    private String libraryId;
    private String patronCategoryId;
    private String materialTypeId;
    private String withEffectFrom;
    private String overAllLoanLimit;
    private String renewalLimit;
    private String finePerDay;
    private String maxCeilOnFine;
    private String renewalThroughOPAC;
    private String otherDetails;
    private String auditUserCode;
    private DurationType loanDurationType;
    private String loanDuration;
    private boolean includeHolidaysInDateDue;
    private List fixedDateDues;
    private DurationType chargeDurationType;
    private boolean includeHolidaysInCharges;
    private String day;
    private String month;
    private String from;
    private String to;
    private String amount;


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

    public String getOverAllLoanLimit() {
        return overAllLoanLimit;
    }

    public void setOverAllLoanLimit(String overAllLoanLimit) {
        this.overAllLoanLimit = overAllLoanLimit;
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

    public String getRenewalThroughOPAC() {
        return renewalThroughOPAC;
    }

    public void setRenewalThroughOPAC(String renewalThroughOPAC) {
        this.renewalThroughOPAC = renewalThroughOPAC;
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

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Boolean getIncludeHolidaysInDateDue() {
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

    public Boolean getIncludeHolidaysInCharges() {
        return includeHolidaysInCharges;
    }

    public void setIncludeHolidaysInCharges(boolean includeHolidaysInCharges) {
        this.includeHolidaysInCharges = includeHolidaysInCharges;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String getLibraryId() {
        return libraryId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
