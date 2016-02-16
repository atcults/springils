package org.sanelib.ils.core.commands.department;

import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Department;

public class AddDepartment extends ProcessCommandWithLibraryId {

    @Override
    public Class getRootEntityClass() {
        return Department.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.department";
    }

    private String deptName;
    private String hodId;
    private String entryId;

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
}
