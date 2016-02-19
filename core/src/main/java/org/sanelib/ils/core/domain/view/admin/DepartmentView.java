package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

import java.util.Date;

public class DepartmentView implements DomainView, ViewWithId {
    private Integer libraryId;
    private Integer id;
    private String deptName;
    private String hodId;
    private String entryId;
    private Date entryDate;


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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

    public String getEntryId() { return entryId; }

    public void setEntryId(String entryId) { this.entryId = entryId; }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "DepartmentView{" +
                "libraryId=" + libraryId +
                ", id=" + id +
                ", deptName='" + deptName + '\'' +
                ", hodId='" + hodId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}


