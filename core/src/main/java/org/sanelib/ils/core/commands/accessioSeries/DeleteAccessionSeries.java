package org.sanelib.ils.core.commands.accessioSeries;

import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.AccessionSeries;

public class DeleteAccessionSeries extends ProcessCommandWithLibraryId implements ProcessCommandWithCode {

    private String code;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Class getRootEntityClass() {
        return AccessionSeries.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.accessionSeries";
    }

}