package org.sanelib.ils.core.commands.accessioSeries;

import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.enums.AccessionSeriesType;

import java.util.Date;

public class AddAccessionSeries extends ProcessCommandWithLibraryId implements ProcessCommandWithCode {

    @Override
    public Class getRootEntityClass() {
        return AccessionSeries.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.accessionSeries";
    }

    private String code;
    private Integer maxNumber;
    private Integer maxZero;
    private String prefix;
    private AccessionSeriesType typeName;
    private String entryId;
    private Date entryDate;

    public String getCode(){
        return code;
    }

    public void setCode(String code){ this.code = code; }

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AccessionSeriesType getTypeName() {
        return typeName;
    }

    public void setTypeName(AccessionSeriesType typeName) {
        this.typeName = typeName;
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
}

