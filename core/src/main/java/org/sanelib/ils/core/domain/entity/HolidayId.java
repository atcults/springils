package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class HolidayId  implements Serializable , LibraryIdAndEntityDate {

    public HolidayId() {
    }

    public HolidayId(int libraryId, Date holidayDayDate){
        this.libraryId = libraryId;
        this.holidayDate = holidayDayDate;

    }

    @Column(name = "library_id")
    private int libraryId;

    @Column(name = "holiday")
    private Date holidayDate;

    @Override
    public int getLibraryId() {
        return libraryId;
    }

    @Override
    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        if(Strings.isNullOrEmpty(String.valueOf(holidayDate)) && !this.holidayDate.equals(holidayDate)){
            throw new IllegalStateException("The holidayId must not be empty");
        }
        this.holidayDate = holidayDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayId holidayId = (HolidayId) o;

        return libraryId == holidayId.libraryId && holidayDate.equals(holidayId.holidayDate);

    }

    @Override
    public int hashCode() {
        int result = libraryId;
        result = 31 * result + holidayDate.hashCode();
        return result;
    }
}
