package org.sanelib.ils.core.commands.patron;


import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Patron;

public class DeletePatron extends ProcessCommandWithLibraryId implements ProcessCommandWithCode {
    private String code;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code=code;
    }

    @Override
    public Class getRootEntityClass() {
        return Patron.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.patron";
    }
}
