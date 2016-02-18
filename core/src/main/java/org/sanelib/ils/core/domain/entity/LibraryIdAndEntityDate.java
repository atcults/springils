package org.sanelib.ils.core.domain.entity;

import java.util.Date;

public interface LibraryIdAndEntityDate {
    int getLibraryId();
    void setLibraryId(int libraryId);
    Date getHolidayDate();
    void setHolidayDate(Date holidayId);
}
