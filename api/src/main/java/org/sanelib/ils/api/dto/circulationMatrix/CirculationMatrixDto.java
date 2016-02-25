package org.sanelib.ils.api.dto.circulationMatrix;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.api.dto.DtoWithLibraryId;
import org.sanelib.ils.core.enums.DurationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CirculationMatrixDto implements DtoWithLibraryId {

    private String libraryId;
    private String patronCategoryId;
    private String materialTypeId;
    private String withEffectFrom;

    private String overAllLoanLimit;
    private String renewalLimit;
    private String finePerDay;
    private String maxFine;
    private String renewalThroughOPAC;
    private String otherDetails;

    private DurationType loanDurationType;

    private String loanDuration;

    private boolean includeHolidaysInDateDue;

    private List<FixedDate> fixedDateDues;

    private DurationType chargeDurationType;

    private boolean includeHolidaysInCharges;

    private List<ChargeDetail> chargeDetails;

    public class FixedDate{
        private String day;
        private String month;

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
    }

    public class ChargeDetail{
        private String from;
        private String to;
        private String amount;

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
    }

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

    public String getMaxFine() {
        return maxFine;
    }

    public void setMaxFine(String maxFine) {
        this.maxFine = maxFine;
    }

    public boolean getRenewalThroughOPAC() {
        return Objects.equals(renewalThroughOPAC, "Y");
    }

    public void setRenewalThroughOPAC(boolean renewalThroughOPAC) {
        this.renewalThroughOPAC = renewalThroughOPAC ? "Y" : "N";
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
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

    public boolean isIncludeHolidaysInDateDue() {
        return includeHolidaysInDateDue;
    }

    public void setIncludeHolidaysInDateDue(boolean includeHolidaysInDateDue) {
        this.includeHolidaysInDateDue = includeHolidaysInDateDue;
    }

    public List<FixedDate> getFixedDateDues() {
        return fixedDateDues;
    }

    public void addFixedDateDue(String day, String month) {
        if(fixedDateDues == null){
            fixedDateDues = new ArrayList<>();
        }

        FixedDate fixedDateDue = new FixedDate();
        fixedDateDue.setDay(day);
        fixedDateDue.setMonth(month);
        fixedDateDues.add(fixedDateDue);
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

    public List<ChargeDetail> getChargeDetails() {
        return chargeDetails;
    }

    public void addChargeDetail(String from, String to, String amount) {
        if(chargeDetails == null){
            chargeDetails = new ArrayList<>();
        }

        ChargeDetail chargeDetail = new ChargeDetail();
        chargeDetail.setFrom(from);
        chargeDetail.setTo(to);
        chargeDetail.setAmount(amount);
        chargeDetails.add(chargeDetail);
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
