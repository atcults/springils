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
    private AccessionSeriesType accessionSeriesType;

    @Column(name="entry_id")
    private String userCode;

    @Column(name="entry_library_id")
    private Integer userLibraryId;

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

    public AccessionSeriesType getAccessionSeriesType() {
        return accessionSeriesType;
    }

    public void setAccessionSeriesType(AccessionSeriesType accessionSeriesType) {
        this.accessionSeriesType = accessionSeriesType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(Integer userLibraryId) {
        this.userLibraryId = userLibraryId;
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }
}
