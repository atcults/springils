package org.sanelib.ils.core.commands.department;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateDepartment extends AddDepartment implements ProcessCommandWithId {

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
