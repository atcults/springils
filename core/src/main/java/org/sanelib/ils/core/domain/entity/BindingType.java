package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="cir_co_bind_types")
public class BindingType implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BindingTypeId bindingTypeId;

    @Column(name="bind_type")
    private String bindType;

    @Column(name = "price")
    private Double price;

    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    public BindingTypeId getBindingTypeId() {
        return bindingTypeId;
    }

    public void setBindingTypeId(BindingTypeId bindingTypeId) {
        this.bindingTypeId = bindingTypeId;
    }

    public void setBindingTypeId(int id, int libraryId){
        if(this.bindingTypeId == null){
            this.bindingTypeId = new BindingTypeId(libraryId, id);
        } else {
            this.bindingTypeId.setId(id);
            this.bindingTypeId.setLibraryId(libraryId);
        }
    }

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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BindingType bindingType = (BindingType) o;
        return bindingTypeId.equals(bindingType.bindingTypeId);
    }

    @Override
    public int hashCode() {
        return bindingTypeId.hashCode();
    }
}
