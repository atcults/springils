package org.sanelib.ils.api.services;

public interface UserSession {
    Integer getUserId();
    void setUserId(Integer userId);
    Integer getLibraryId();
    void setLibraryId(Integer libraryId);
}

