package org.sanelib.ils.core.domain.entity;

public interface LibraryIdAndEntityId extends EmbeddedKey {
    int getLibraryId();
    void setLibraryId(int libraryId);
    int getId();
    void setId(int id);
}

