package org.sanelib.ils.core.commands.accessioSeries;

import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.enums.AccessionSeriesType;

public class AddAccessionSeries extends ProcessAuditCommandWithLibraryId implements ProcessCommandWithCode {

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
}

