package org.sanelib.ils.api.dto.bindingType;


import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class BindingTypeDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String bindType;
    private String price;
    private String entryId;

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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

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
}
