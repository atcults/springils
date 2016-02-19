package org.sanelib.ils.api.dto.serialBoundVolume;

import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class SerialBoundVolumeDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String name;
    private String color;
    private String price;
    private String entryId;

    @Override
    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

}
