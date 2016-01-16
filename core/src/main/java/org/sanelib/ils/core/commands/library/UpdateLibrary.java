package org.sanelib.ils.core.commands.library;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateLibrary extends AddLibrary implements ProcessCommandWithId {

    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateLibrary{" +
                "id=" + id +
                "} " + super.toString();
    }
}