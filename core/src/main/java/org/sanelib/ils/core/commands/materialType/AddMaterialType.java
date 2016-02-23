package org.sanelib.ils.core.commands.materialType;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.domain.entity.MaterialType;

public class AddMaterialType implements ProcessCommandWithId {
    @Override
    public Class getRootEntityClass() {
        return MaterialType.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.materialType";
    }

    private Integer id;
    private String materialType;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

}
