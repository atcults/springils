package org.sanelib.ils.core.domain.view.admin;


import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

import java.util.Date;

public class CourseView implements DomainView, ViewWithId{

    private Integer libraryId;
    private Integer id;
    private String courseName;
    private Double hodId;
    private String entryId;
    private Date entryDate;
    private Integer pCourseId;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getHodId() {
        return hodId;
    }

    public void setHodId(Double hodId) {
        this.hodId = hodId;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getpCourseId() {
        return pCourseId;
    }

    public void setpCourseId(Integer pCourseId) {
        this.pCourseId = pCourseId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){

        return "CourseView{" +
                "libraryId=" +libraryId +
                "id=" +id +
                "courseName=" +courseName+
                "hodId=" +hodId+
                "entryId=" +entryId+
                "entryDate=" +entryDate+
                "pCourseId=" +pCourseId+
                '}';
    }
}
