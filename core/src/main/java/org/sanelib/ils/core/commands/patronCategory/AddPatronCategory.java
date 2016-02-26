package org.sanelib.ils.core.commands.patronCategory;


import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.PatronCategory;

public class AddPatronCategory extends ProcessCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return PatronCategory.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.patronCategory";
    }

    private String name;
    private boolean allowILLFromNet;
    private boolean allowRenewalFromNet;
    private Integer overallLoanLimit;
    private boolean allowMultipleCopies;
    private String acqWorkflow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllowILLFromNet() {
        return allowILLFromNet;
    }

    public void setAllowILLFromNet(boolean allowILLFromNet) {
        this.allowILLFromNet = allowILLFromNet;
    }

    public boolean isAllowRenewalFromNet() {
        return allowRenewalFromNet;
    }

    public void setAllowRenewalFromNet(boolean allowRenewalFromNet) {
        this.allowRenewalFromNet = allowRenewalFromNet;
    }

    public Integer getOverallLoanLimit() {
        return overallLoanLimit;
    }

    public void setOverallLoanLimit(Integer overallLoanLimit) {
        this.overallLoanLimit = overallLoanLimit;
    }

    public boolean isAllowMultipleCopies() {
        return allowMultipleCopies;
    }

    public void setAllowMultipleCopies(boolean allowMultipleCopies) {
        this.allowMultipleCopies = allowMultipleCopies;
    }

    public String getAcqWorkflow() {
        return acqWorkflow;
    }

    public void setAcqWorkflow(String acqWorkflow) {
        this.acqWorkflow = acqWorkflow;
    }
}
