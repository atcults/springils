package org.sanelib.ils.core.commands.materialType;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.domain.entity.MaterialType;

public class DeleteMaterialType implements ProcessCommandWithId{
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return MaterialType.class;
    }

    @Override
    public String getRootEntityName() {
        return  "domain.entity.materialType";
    }
}
