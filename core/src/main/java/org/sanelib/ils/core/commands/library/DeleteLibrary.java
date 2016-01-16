package org.sanelib.ils.core.commands.library;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.domain.entity.Library;

public class DeleteLibrary implements ProcessCommandWithId {

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
        return Library.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.library";
    }
}