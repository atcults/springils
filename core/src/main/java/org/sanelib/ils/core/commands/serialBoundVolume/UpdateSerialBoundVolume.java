package org.sanelib.ils.core.commands.serialBoundVolume;


import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateSerialBoundVolume extends AddSerialBoundVolume implements ProcessCommandWithId{
    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
