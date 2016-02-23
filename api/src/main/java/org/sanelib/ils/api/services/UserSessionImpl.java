package org.sanelib.ils.api.services;

public class UserSessionImpl implements UserSession {

    private String userCode;
    private Integer libraryId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }
}
