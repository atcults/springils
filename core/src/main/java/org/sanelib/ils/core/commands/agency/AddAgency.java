package org.sanelib.ils.core.commands.agency;

import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Agency;

public class AddAgency extends ProcessCommandWithLibraryId {

    @Override
    public Class getRootEntityClass() {
        return Agency.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.agency";
    }

}

