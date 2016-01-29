package org.sanelib.ils.core.commands.fiscalYear;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.FiscalYear;

public class DeleteFiscalYear extends ProcessCommandWithLibraryId implements ProcessCommandWithId {

    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return FiscalYear.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.fiscalYear";
    }
}