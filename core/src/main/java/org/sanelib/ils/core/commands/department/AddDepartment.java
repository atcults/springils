package org.sanelib.ils.core.commands.department;

import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Department;

public class AddDepartment extends ProcessAuditCommandWithLibraryId {

    @Override
    public Class getRootEntityClass() {
        return Department.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.department";
    }

    private String name;
    private String hodId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

}
