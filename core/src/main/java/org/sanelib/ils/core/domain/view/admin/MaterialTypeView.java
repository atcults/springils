package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;

public class MaterialTypeView implements DomainView{
    private String materialTypeName;

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    @Override
    public String toString() {
        return "MaterialTypeView{" +
                "materialTypeName='" + materialTypeName + '\'' +
                '}';
    }
}
