package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

import java.util.Date;

public class BindingTypeView implements DomainView, ViewWithId {

    private Integer libraryId;
    private Integer id;
    private String bindType;
    private Double price;
    private String entryId;
    private Date entryDate;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "BindingTypeView{" +
                "libraryId=" + libraryId +
                ", id=" + id +
                ", bindType='" + bindType + '\'' +
                ", price=" + price +
                ", entryId='" + entryId + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}


