package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithCode;
import org.sanelib.ils.core.enums.AccessionSeriesType;

public class AccessionSeriesView implements DomainView, ViewWithCode {

    private Integer libraryId;
    private String name;
    private AccessionSeriesType accessionSeriesType;
    private String prefix;
    private Integer maxNumber;
    private Integer maxZero;

    @Override
    public String getCode() {
        return name;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessionSeriesType getAccessionSeriesType() {
        return accessionSeriesType;
    }

    public void setAccessionSeriesType(AccessionSeriesType accessionSeriesType) {
        this.accessionSeriesType = accessionSeriesType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getMaxZero() {
        return maxZero;
    }

    public void setMaxZero(Integer maxZero) {
        this.maxZero = maxZero;
    }
}
