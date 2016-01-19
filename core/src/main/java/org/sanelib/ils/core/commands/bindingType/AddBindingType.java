package org.sanelib.ils.core.commands.bindingType;


import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.BindingType;

import java.util.Date;

public class AddBindingType extends ProcessCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return BindingType.class;
    }

    @Override
    public String getRootEntityName() {
        return  "domain.entity.bindingType";
    }

    private String bindType;
    private Integer price;
    private String entryId;
    private Date entryDate;

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
