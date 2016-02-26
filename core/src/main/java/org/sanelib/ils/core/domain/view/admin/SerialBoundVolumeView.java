package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;


public class SerialBoundVolumeView implements DomainView, ViewWithId {

    private Integer libraryId;
    private Integer bindTypeId;
    private String name;
    private String color;
    private Double price;

    public Integer getLibraryId() {  return libraryId;  }

    public void setLibraryId(Integer libraryId) { this.libraryId = libraryId; }

    public Integer getBindTypeId() { return bindTypeId; }

    public void setBindTypeId(Integer bindTypeId) { this.bindTypeId = bindTypeId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getColor() { return color;  }

    public void setColor(String color) { this.color = color; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    @Override
    public Integer getId() {
        return bindTypeId;
    }

    @Override
    public String toString() {
        return "SerialBoundVolumeView{" +
                "libraryId=" + libraryId +
                ", bindTypeId=" + bindTypeId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
