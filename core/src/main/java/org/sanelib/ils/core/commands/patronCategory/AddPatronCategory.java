package org.sanelib.ils.core.commands.patronCategory;


import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.PatronCategory;

import java.util.Date;

public class AddPatronCategory extends ProcessCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return PatronCategory.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.patronCategory";
    }

    private String patronCategoryName;
    private String illThruNet;
    private String renewalThruNet;
    private Date entryDate;
    private Integer overallLoanLimit;
    private String allowMultipleCopies;
    private String acqWorkflow;

    public String getPatronCategoryName() {
        return patronCategoryName;
    }

    public void setPatronCategoryName(String patronCategoryName) {
        this.patronCategoryName = patronCategoryName;
    }

    public String getIllThruNet() {
        return illThruNet;
    }

    public void setIllThruNet(String illThruNet) {
        this.illThruNet = illThruNet;
    }

    public String getRenewalThruNet() {
        return renewalThruNet;
    }

    public void setRenewalThruNet(String renewalThruNet) {
        this.renewalThruNet = renewalThruNet;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getOverallLoanLimit() {
        return overallLoanLimit;
    }

    public void setOverallLoanLimit(Integer overallLoanLimit) {
        this.overallLoanLimit = overallLoanLimit;
    }

    public String getAllowMultipleCopies() {
        return allowMultipleCopies;
    }

    public void setAllowMultipleCopies(String allowMultipleCopies) {
        this.allowMultipleCopies = allowMultipleCopies;
    }

    public String getAcqWorkflow() {
        return acqWorkflow;
    }

    public void setAcqWorkflow(String acqWorkflow) {
        this.acqWorkflow = acqWorkflow;
    }
}
