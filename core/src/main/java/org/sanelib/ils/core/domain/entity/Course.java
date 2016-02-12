package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

    @Column(name = "hod_id")
    private Double hodId;

    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "p_course_id")
    private int pCourseId;

    public Course() {
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseId courseId) { this.courseId = courseId;    }

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

    public int getpCourseId() {
        return pCourseId;
    }

    public void setpCourseId(int pCourseId) {
        this.pCourseId = pCourseId;
    }

    public void setCourseId(int id,int libraryId){
        if(this.courseId==null){
            this.courseId=new CourseId(libraryId,id);
        }else{
            this.courseId.setId(id);
            this.courseId.setLibraryId(libraryId);
        }
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


}
