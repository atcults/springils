package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class CirculationMatrixId implements Serializable {

    public CirculationMatrixId() {

    }

    public CirculationMatrixId(Integer libraryId, Integer patronCategoryId, Integer materialTypeId, Date withEffectFrom) {
        this.libraryId = libraryId;
        this.patronCategoryId = patronCategoryId;
        this.materialTypeId = materialTypeId;
        this.withEffectFrom = withEffectFrom;
    }

    @Column(name = "library_id")
    private Integer libraryId;

    @Column(name = "patron_category_id")
    private Integer patronCategoryId;

    @Column(name = "material_type_id")
    private Integer materialTypeId;

    @Column(name = "wef")
    private Date withEffectFrom;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Date getWithEffectFrom() {
        return withEffectFrom;
    }

    public void setWithEffectFrom(Date withEffectFrom) {
        this.withEffectFrom = withEffectFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CirculationMatrixId that = (CirculationMatrixId) o;

        if (libraryId != null ? !libraryId.equals(that.libraryId) : that.libraryId != null) return false;
        if (patronCategoryId != null ? !patronCategoryId.equals(that.patronCategoryId) : that.patronCategoryId != null)
            return false;
        if (materialTypeId != null ? !materialTypeId.equals(that.materialTypeId) : that.materialTypeId != null)
            return false;
        return withEffectFrom != null ? withEffectFrom.equals(that.withEffectFrom) : that.withEffectFrom == null;

    }

    @Override
    public int hashCode() {
        int result = libraryId != null ? libraryId.hashCode() : 0;
        result = 31 * result + (patronCategoryId != null ? patronCategoryId.hashCode() : 0);
        result = 31 * result + (materialTypeId != null ? materialTypeId.hashCode() : 0);
        result = 31 * result + (withEffectFrom != null ? withEffectFrom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CirculationMatrixId{" +
                "libraryId=" + libraryId +
                ", patronCategoryId=" + patronCategoryId +
                ", materialTypeId=" + materialTypeId +
                ", withEffectFrom=" + withEffectFrom +
                '}';
    }
}