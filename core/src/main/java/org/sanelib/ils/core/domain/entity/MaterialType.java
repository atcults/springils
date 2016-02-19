package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_co_material_type")
public class MaterialType implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "material_type_id")
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        if (this.id != 0 && this.id != id) {
            throw new IllegalStateException("The ID must not be changed after it is set.");
        }
        this.id = id;
    }

    @Column(name = "material_type")
    private String materialType;

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
