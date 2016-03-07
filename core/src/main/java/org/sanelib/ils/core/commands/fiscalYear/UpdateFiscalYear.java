package org.sanelib.ils.core.commands.fiscalYear;

import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateFiscalYear extends AddFiscalYear implements ProcessCommandWithId{
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
