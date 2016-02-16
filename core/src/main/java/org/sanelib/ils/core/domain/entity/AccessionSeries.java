package org.sanelib.ils.core.domain.entity;

import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.sanelib.ils.core.enums.AccessionSeriesTypeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "accession_series")
public class AccessionSeries implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AccessionSeriesCode accessionSeriesCode;

    public AccessionSeriesCode getAccessionSeriesCode() {
        return accessionSeriesCode;
    }

    public void setAccessionSeriesCode(AccessionSeriesCode accessionSeriesCode) {
        this.accessionSeriesCode = accessionSeriesCode;
    }

    public void setAccessionSeriesCode(String code, int libraryId){
        if(this.accessionSeriesCode == null){
            this.accessionSeriesCode = new AccessionSeriesCode(libraryId, code);
        } else {
            this.accessionSeriesCode.setCode(code);
            this.accessionSeriesCode.setLibraryId(libraryId);
        }
    }

    @Column(name = "max_number")
    private Integer maxNumber;

    @Column(name = "max_zero")
    private Integer maxZero;

    @Column(name = "prefix")
    private String prefix;

    //NOTE: Fixed_variable stores 1 character. Series type is fixed or variable.
    @Convert( converter = AccessionSeriesTypeConverter.class )
    @Column(name = "fixed_variable")
    private AccessionSeriesType typeName;

    @Column(name="entry_library_id")
    private Integer entryLibraryId;

    @Column(name="entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber){this.maxNumber = maxNumber; }

    public Integer getMaxZero() {
        return maxZero;
    }

    public void setMaxZero(Integer maxZero) {
        this.maxZero = maxZero;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AccessionSeriesType getTypeName() {
        return typeName;
    }

    public void setTypeName(AccessionSeriesType typeName) {
        this.typeName = typeName;
    }

    public Integer getEntryLibraryId() { return entryLibraryId; }

    public void setEntrylibraryId(Integer entryLibraryId) { this.entryLibraryId = entryLibraryId; }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }
}
