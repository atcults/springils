package org.sanelib.ils.core.commands.binder;


import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Binder;

public class DeleteBinder extends ProcessCommandWithLibraryId implements ProcessCommandWithId {
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public Class getRootEntityClass() {
        return Binder.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.binder";
    }
}
