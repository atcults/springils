package org.sanelib.ils.core.commands;

public interface ProcessCommandWithCode extends ProcessCommand {

    String getCode();
    void setCode(String code);

    Class getRootEntityClass();
}
