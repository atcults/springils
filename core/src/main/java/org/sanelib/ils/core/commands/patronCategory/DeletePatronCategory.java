package org.sanelib.ils.core.commands.patronCategory;

import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.PatronCategory;

public class DeletePatronCategory extends ProcessCommandWithLibraryId implements ProcessCommandWithId {

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
        return PatronCategory.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.patronCategory";
    }
}