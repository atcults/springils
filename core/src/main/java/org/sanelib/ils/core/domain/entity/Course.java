package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CourseId courseId;

    @Column(name = "course_name")
    private String name;

    @Column(name = "entry_id")
    private String userCode;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "p_course_id")
    private Integer promotedCourseId;

    public Course() {
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(int id,int libraryId){
        if(this.courseId==null){
            this.courseId=new CourseId(libraryId,id);
        }else{
            this.courseId.setId(id);
            this.courseId.setLibraryId(libraryId);
        }
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public Integer getPromotedCourseId() {
        return promotedCourseId;
    }

    public void setPromotedCourseId(Integer promotedCourseId) {
        this.promotedCourseId = promotedCourseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return courseId.hashCode();
    }

    @PrePersist
    public void prePersist(){
        entryDate = new Date();
    }
}
