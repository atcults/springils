package org.sanelib.ils.core.commands.agency;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.library.AddLibrary;

public class UpdateAgency extends AddLibrary implements ProcessCommandWithId {

    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
