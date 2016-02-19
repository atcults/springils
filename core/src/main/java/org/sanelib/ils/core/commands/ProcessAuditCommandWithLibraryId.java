package org.sanelib.ils.core.commands;

public abstract class ProcessAuditCommandWithLibraryId extends ProcessCommandWithLibraryId {

    private String patronCode;
    private Integer patronLibraryId;

    public String getPatronCode() {
        return patronCode;
    }

    public void setPatronCode(String patronCode) {
        this.patronCode = patronCode;
    }

    public Integer getPatronLibraryId() {
        return patronLibraryId;
    }

    public void setPatronLibraryId(Integer patronLibraryId) {
        this.patronLibraryId = patronLibraryId;
    }

    @Override
    public String toString() {
        return "ProcessAuditCommandWithLibraryId{" +
                "patronCode=" + patronCode +
                ", patronLibraryId=" + patronLibraryId +
                "} " + super.toString();
    }
}
