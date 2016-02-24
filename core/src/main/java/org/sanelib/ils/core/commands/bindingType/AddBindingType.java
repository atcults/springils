package org.sanelib.ils.core.commands.bindingType;


import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.BindingType;

public class AddBindingType extends ProcessAuditCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return BindingType.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.bindingType";
    }

    private String bindType;
    private Double price;

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}