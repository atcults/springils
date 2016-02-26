package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sm_co_bind_specification")
public class SerialBoundVolume implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SerialBoundVolumeId serialBoundVolumeId;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Double price;

    @Column(name = "entry_id")
    private String userCode;

    @Column(name = "entry_date")
    private Date entryDate;

    public SerialBoundVolumeId getSerialBoundVolumeId() {
        return serialBoundVolumeId;
    }

    public void setSerialBoundVolumeId(SerialBoundVolumeId serialBoundVolumeId) {
        this.serialBoundVolumeId = serialBoundVolumeId;
    }

    public void setSerialBoundVolumeId(int id, int libraryId){
        if(this.serialBoundVolumeId == null){
            this.serialBoundVolumeId = new SerialBoundVolumeId(libraryId, id);
        } else {
            this.serialBoundVolumeId.setId(id);
            this.serialBoundVolumeId.setLibraryId(libraryId);
        }
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @PrePersist
    public void prePersist() {

        entryDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerialBoundVolume serialBoundVolume = (SerialBoundVolume) o;

        return serialBoundVolumeId.equals(serialBoundVolume.serialBoundVolumeId);

    }

    @Override
    public int hashCode() {
        return serialBoundVolumeId.hashCode();
    }

}
