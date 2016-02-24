package org.sanelib.ils.api.services;

public interface UserSession {
    String getUserCode();
    void setUserCode(String userCode);
    Integer getLibraryId();
    void setLibraryId(Integer libraryId);
}

