package org.sanelib.ils.core.commands.patronCategory;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdatePatronCategory extends AddPatronCategory implements ProcessCommandWithId {

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
