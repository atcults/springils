package org.sanelib.ils.api.services;

public class UserSessionImpl implements UserSession {
    private Integer userId;
    private Integer libraryId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }
}
