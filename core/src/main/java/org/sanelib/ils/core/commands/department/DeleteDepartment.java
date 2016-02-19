package org.sanelib.ils.core.commands.department;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Department;

public class DeleteDepartment extends ProcessCommandWithLibraryId implements ProcessCommandWithId {

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return Department.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.department";
    }
}
