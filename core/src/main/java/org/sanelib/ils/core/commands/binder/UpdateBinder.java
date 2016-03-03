package org.sanelib.ils.core.commands.binder;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateBinder extends AddBinder implements ProcessCommandWithId{

    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }
}
