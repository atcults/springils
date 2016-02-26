package org.sanelib.ils.common.session;

public interface UserSession {
    String getUserCode();
    void setUserCode(String userCode);
    Integer getLibraryId();
    void setLibraryId(Integer libraryId);
}

