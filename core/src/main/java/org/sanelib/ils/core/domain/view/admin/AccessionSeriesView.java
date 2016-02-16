package org.sanelib.ils.core.domain.view.admin;

import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithCode;
import org.sanelib.ils.core.enums.AccessionSeriesType;

import java.util.Date;

public class AccessionSeriesView implements DomainView, ViewWithCode {

    private String seriesName;
    private Integer libraryId;
    private Integer maxNumber;
    private Integer maxZero;
    private AccessionSeriesType typeName;
    private Date entryDate;
    private String prefix;
    private String entryId;
    private Integer entryLibraryId;

    public Integer getEntryLibraryId() { return entryLibraryId; }

    public void setEntryLibraryId(Integer entryLibraryId) { this.entryLibraryId = entryLibraryId; }

    public String getSeriesName() { return seriesName;  }

    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }

    public Integer getLibraryId() { return libraryId; }

    public void setLibraryId(Integer libraryId) { this.libraryId = libraryId; }

    public Integer getMaxNumber() { return maxNumber; }

    public void setMaxNumber(Integer maxNumber) { this.maxNumber = maxNumber; }

    public Integer getMaxZero() { return maxZero; }

    public void setMaxZero(Integer maxZero) { this.maxZero = maxZero; }

    public AccessionSeriesType getTypeName() { return typeName; }

    public void setTypeName(AccessionSeriesType typeName) { this.typeName = typeName; }

    public Date getEntryDate() { return entryDate; }

    public void setEntryDate(Date entryDate) { this.entryDate = entryDate; }

    public String getPrefix() { return prefix; }

    public void setPrefix(String prefix) { this.prefix = prefix; }

    public String getEntryId() { return entryId; }

    public void setEntryId(String entryId) { this.entryId = entryId; }

    @Override
    public String toString() {
        return "AccessionSeriesView{" +
                "seriesName='" + seriesName + '\'' +
                ", libraryId=" + libraryId +
                ", maxNumber=" + maxNumber +
                ", maxZero=" + maxZero +
                ", typeName=" + typeName +
                ", entryDate=" + entryDate +
                ", entryLibraryId"+entryLibraryId+
                ", prefix='" + prefix + '\'' +
                ", entryId='" + entryId + '\'' +
                '}';
    }

    @Override
    public String getCode() {
        return seriesName;
    }
}
