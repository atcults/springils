package org.sanelib.ils.core.domain.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patron_category")
public class PatronCategory implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PatronCategoryId patronCategoryId;

    @Column(name = "patron_category_name")
    private String name;

    @Column(name = "ill_thru_net")
    private char allowILLFromNet;

    @Column(name = "renewal_thru_net")
    private char allowRenewalFromNet;

    @Column(name = "overall_loan_limit")
    private Integer overallLoanLimit;

    @Column(name="allow_multiple_copies")
    private char allowMultipleCopies;

    @Column(name="acq_workflow")
    private String acqWorkflow;

    @Column(name = "entry_date")
    private Date entryDate;

    public PatronCategoryId getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(int id, int libraryId){
        if(this.patronCategoryId == null){
            this.patronCategoryId = new PatronCategoryId(libraryId, id);
        } else {
            this.patronCategoryId.setId(id);
            this.patronCategoryId.setLibraryId(libraryId);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String patronCategoryName) {
        this.name = patronCategoryName;
    }

    public Integer getOverallLoanLimit() {
        return overallLoanLimit;
    }

    public void setOverallLoanLimit(Integer overallLoanLimit) {
        this.overallLoanLimit = overallLoanLimit;
    }

    public boolean getAllowILLFromNet() {
        return allowILLFromNet == '1';
    }

    public void setAllowILLFromNet(boolean allowILLFromNet) {
        this.allowILLFromNet = allowILLFromNet ? '1' : '0';
    }

    public boolean getAllowRenewalFromNet() {
        return allowRenewalFromNet == '1';
    }

    public void setAllowRenewalFromNet(boolean allowRenewalFromNet) {
        this.allowRenewalFromNet = allowRenewalFromNet ? '1': '0';
    }

    public boolean getAllowMultipleCopies() {
        return allowMultipleCopies == '1';
    }

    public void setAllowMultipleCopies(boolean allowMultipleCopies) {
        this.allowMultipleCopies = allowMultipleCopies ? '1' : '0';
    }

    public String getAcqWorkflow() {
        return acqWorkflow;
    }

    public void setAcqWorkflow(String acqWorkflow) {
        this.acqWorkflow = acqWorkflow;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatronCategory patronCategory = (PatronCategory) o;
        return patronCategoryId.equals(patronCategory.patronCategoryId);

    }

    @Override
    public int hashCode() {
        return patronCategoryId.hashCode();
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }
}
