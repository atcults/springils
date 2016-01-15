package org.sanelib.ils.core.commands;

public interface ProcessCommandWithId extends ProcessCommand {

    Integer getId();
    void setId(Integer id);

    Class getRootEntityClass();
}
