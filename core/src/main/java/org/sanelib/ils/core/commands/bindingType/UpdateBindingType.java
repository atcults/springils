package org.sanelib.ils.core.commands.bindingType;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateBindingType extends AddBindingType implements ProcessCommandWithId {

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
