package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "dept")
public class Department implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DepartmentId departmentId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "hod_id")
    private String hodId;

    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Timestamp entryDate;

    public DepartmentId getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentId departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(int id, int libraryId){
        if(this.departmentId == null){
            this.departmentId = new DepartmentId(libraryId, id);
        }
        else{
            this.departmentId.setId(id);
            this.departmentId.setLibraryId(libraryId);
        }
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department dept = (Department) o;

        return departmentId.equals(dept.departmentId);
    }

    @Override
    public int hashCode() {
        return departmentId.hashCode();
    }
}
