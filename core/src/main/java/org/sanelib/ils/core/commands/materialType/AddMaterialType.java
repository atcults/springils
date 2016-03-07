package org.sanelib.ils.core.commands.materialType;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.domain.entity.MaterialType;

public class AddMaterialType implements ProcessCommand {
    @Override
    public Class getRootEntityClass() {
        return MaterialType.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.materialType";
    }

    private String materialType;

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

}
