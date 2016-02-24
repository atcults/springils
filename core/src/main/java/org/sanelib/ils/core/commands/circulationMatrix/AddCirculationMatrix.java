package org.sanelib.ils.core.commands.circulationMatrix;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.enums.DurationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AddCirculationMatrix extends ProcessCommandWithLibraryId implements ProcessCommand{

    @Override
    public Class getRootEntityClass() {
        return CirculationMatrix.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.circulationMatrix";
    }

    private Integer patronCategoryId;
    private Integer materialTypeId;
    private Date withEffectFrom;

    private Integer overAllLoanLimit;
    private Integer renewalLimit;
    private Double finePerDay;
    private Double maxFine;
    private String renewalThroughOPAC;

    private DurationType loanDurationType;

    private Integer loanDuration;

    private boolean includeHolidaysInDateDue;

    private List<FixedDate> fixedDateDues;

    private DurationType chargeDurationType;

    private boolean includeHolidaysInCharges;

    private List<ChargeDetail> chargeDetails;

    public class FixedDate{
        private Integer day;
        private Integer month;

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
    }

    public class ChargeDetail{
        private Integer from;
        private Integer to;
        private Double amount;

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

    public Double getMaxFine() {
        return maxFine;
    }

    public void setMaxFine(Double maxFine) {
        this.maxFine = maxFine;
    }

    public boolean getRenewalThroughOPAC() {
        return Objects.equals(renewalThroughOPAC, "Y");
    }

    public void setRenewalThroughOPAC(Boolean renewalThroughOPAC) {
        this.renewalThroughOPAC = renewalThroughOPAC ? "Y" : "N";
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

    public List<FixedDate> getFixedDateDues() {
        return fixedDateDues;
    }

    public void addFixedDateDue(int day, int month) {
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

    public void addChargeDetail(int from, int to, Double amount) {
        if(chargeDetails == null){
            chargeDetails = new ArrayList<>();
        }

        ChargeDetail chargeDetail = new ChargeDetail();
        chargeDetail.setFrom(from);
        chargeDetail.setTo(to);
        chargeDetail.setAmount(amount);
        chargeDetails.add(chargeDetail);
    }
}
