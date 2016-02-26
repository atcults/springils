package org.sanelib.ils.core.domain.view.admin;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

public class CourseView implements DomainView, ViewWithId{

    private Integer libraryId;
    private Integer id;
    private String courseName;
    private Integer promotedCourseId;

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

    public Integer getPromotedCourseId() {
        return promotedCourseId;
    }

    public void setPromotedCourseId(Integer promotedCourseId) {
        this.promotedCourseId = promotedCourseId;
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
