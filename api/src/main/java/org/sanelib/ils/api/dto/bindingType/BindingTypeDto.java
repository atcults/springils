package org.sanelib.ils.api.dto.bindingType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class BindingTypeDto implements DtoWithId, DtoWithLibraryId {

    private String id;
    private String libraryId;
    private String bindType;
    private String price;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(String libraryId){
        this.libraryId = libraryId;
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
