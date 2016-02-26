package org.sanelib.ils.core.commands.binderOrder;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateBinderOrder extends AddBinderOrder implements ProcessCommandWithId {

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
