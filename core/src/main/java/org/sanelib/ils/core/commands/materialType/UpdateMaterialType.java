package org.sanelib.ils.core.commands.materialType;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateMaterialType extends AddMaterialType implements ProcessCommandWithId {

    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
