package org.sanelib.ils.core.commands.course;


import org.sanelib.ils.core.commands.ProcessCommandWithId;

public class UpdateCourse extends AddCourse implements ProcessCommandWithId {

    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
