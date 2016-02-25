package org.sanelib.ils.core.commands;

public abstract class ProcessCommandWithLibraryId implements ProcessCommand {

    private Integer libraryId;

    public Integer getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "ProcessCommandWithLibraryId{" +
                "libraryId=" + libraryId +
                '}';
    }
}


