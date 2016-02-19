package org.sanelib.ils.core.commands.serialBoundVolume;


import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;

public class AddSerialBoundVolume extends ProcessAuditCommandWithLibraryId {
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

}
