package org.sanelib.ils.core.domain.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "patron_category")
public class PatronCategory implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PatronCategoryId patronCategoryId;

    @Column(name = "patron_category_name")
    private String patronCategoryName;

    @Column(name = "ill_thru_net")
    private String illThruNet;

    @Column(name = "renewal_thru_net")
    private String renewalThruNet;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "overall_loan_limit")
    private Integer overallLoanLimit;

    @Column(name="allow_multiple_copies")
    private String allowMultipleCopies;

    @Column(name="acq_workflow")
    private String acqWorkflow;

    public PatronCategoryId getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(PatronCategoryId patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public String getPatronCategoryName() {
        return patronCategoryName;
    }

    public void setPatronCategoryId(int id, int libraryId){
        if(this.patronCategoryId == null){
            this.patronCategoryId = new PatronCategoryId(libraryId, id);
        } else {
            this.patronCategoryId.setId(id);
            this.patronCategoryId.setLibraryId(libraryId);
        }
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
}
