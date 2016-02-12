package org.sanelib.ils.core.commands;

public abstract class ProcessAuditCommandWithLibraryId extends ProcessCommandWithLibraryId {

    private Integer entryId;
    private Integer entryLibraryId;

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getEntryLibraryId() {
        return entryLibraryId;
    }

    public void setEntryLibraryId(Integer entryLibraryId) {
        this.entryLibraryId = entryLibraryId;
    }

    @Override
    public String toString() {
        return "ProcessAuditCommandWithLibraryId{" +
                "entryId=" + entryId +
                ", entryLibraryId=" + entryLibraryId +
                "} " + super.toString();
    }
}
