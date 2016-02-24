package org.sanelib.ils.core.commands.circulationMatrix;

import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;

import java.util.Date;

public class DeleteCirculationMatrix extends ProcessCommandWithLibraryId implements ProcessCommand {

    private Integer patronCategoryId;
    private Integer materialTypeId;
    private Date withEffectFrom;

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Date getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(Date withEffectFrom) {
        this.withEffectFrom = withEffectFrom;
    }

    @Override
    public Class getRootEntityClass() {
        return CirculationMatrix.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.circulationMatrix";
    }



}
