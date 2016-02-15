package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccessionSeriesCode implements Serializable, LibraryIdAndEntityCode {

    public AccessionSeriesCode(){

    }

    public AccessionSeriesCode(Integer libraryId, String code) {
        this.libraryId = libraryId;
        this.code = code;
    }

    @Column(name = "library_id")
    private int libraryId;

    @Column(name = "series_name")
    private String code;

    @Override
    public int getLibraryId() {
        return libraryId;
    }

    @Override
    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getCode() {
        return Strings.isNullOrEmpty(this.code) ? null : this.code.trim();
    }

    public void setCode(String code) {
        if (Strings.isNullOrEmpty(code) && !this.code.equals(code)) {
            throw new IllegalStateException("The CODE must not be changed after it is set.");
        }
        this.code = code.trim();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessionSeriesCode accessionSeriesCode = (AccessionSeriesCode) o;

        return libraryId == accessionSeriesCode.libraryId && code.equals(accessionSeriesCode.code);
    }

    @Override
    public int hashCode() {
        int result = libraryId;
        result = 31 * result + code.hashCode();
        return result;
    }
}
