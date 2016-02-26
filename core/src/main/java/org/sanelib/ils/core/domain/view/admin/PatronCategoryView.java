package org.sanelib.ils.core.domain.view.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

public class PatronCategoryView implements DomainView, ViewWithId {

    private Integer libraryId;
    private Integer id;
    private String name;
    private boolean allowILLFromNet;
    private boolean allowRenewalFromNet;
    private Integer overallLoanLimit;
    private boolean allowMultipleCopies;
    private String acqWorkflow;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


