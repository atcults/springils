package org.sanelib.ils.core.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept")
public class Department implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DepartmentId departmentId;

    @Column(name = "dept_name")
    private String name;

    @Column(name = "hod_id")
    private String hodId;

    @Column(name = "entry_id")
    private String userCode;

    @Column(name = "entry_date")
    private Date entryDate;

    public DepartmentId getDepartmentId() {
        return departmentId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }
}
