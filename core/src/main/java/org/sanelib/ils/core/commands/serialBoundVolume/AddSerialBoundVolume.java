package org.sanelib.ils.core.commands.serialBoundVolume;


import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;

import java.util.Date;

public class AddSerialBoundVolume extends ProcessCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return SerialBoundVolume.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.serialBoundVolume";
    }

    private String name;
    private String color;
    private Double price;
    private String entryId;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

}
