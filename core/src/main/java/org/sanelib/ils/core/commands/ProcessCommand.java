package org.sanelib.ils.core.commands;

import java.io.Serializable;

public interface ProcessCommand extends Serializable {
    Class getRootEntityClass();
    String getRootEntityName();
}