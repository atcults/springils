package org.sanelib.ils.api.dto.accessionSeries;

import org.sanelib.ils.api.dto.DtoWithCode;
import org.sanelib.ils.api.dto.DtoWithLibraryId;
import org.sanelib.ils.core.enums.AccessionSeriesType;

public class AccessionSeriesDto implements DtoWithCode, DtoWithLibraryId {

    private String libraryId;
    private String code;
    private String maxNumber;
    private String maxZero;
    private String prefix;
    private AccessionSeriesType typeName;
    private String entryId;
    private String entryDate;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(String libraryId){
        this.libraryId = libraryId;
    }

    public String getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getMaxZero() {
        return maxZero;
    }

    public void setMaxZero(String maxZero) {
        this.maxZero = maxZero;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public AccessionSeriesType getTypeName() {
        return typeName;
    }

    public void setTypeName(AccessionSeriesType  typeName) {
        this.typeName = typeName;
    }
}

