package org.sanelib.ils.api.dto.patronCategory;


import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class PatronCategoryDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String patronCategoryName;
    private String illThruNet;
    private String renewalThruNet;
    private String entryDate;
    private String overallLoanLimit;
    private String allowMultipleCopies;
    private String acqWorkflow;

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getOverallLoanLimit() {
        return overallLoanLimit;
    }

    public void setOverallLoanLimit(String overallLoanLimit) {
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
