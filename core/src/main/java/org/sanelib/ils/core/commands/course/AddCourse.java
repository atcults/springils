package org.sanelib.ils.core.commands.course;

import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Course;

import java.util.Date;

public class AddCourse extends ProcessCommandWithLibraryId {

    @Override
    public Class getRootEntityClass() {
        return Course.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.course";
    }

    private String name;
    private Double hodId;
    private String entryId;
    private Date entryDate;
    private int pCourseId;

    public Double getHodId() {
        return hodId;
    }

    public void setHodId(Double hodId) {
        this.hodId = hodId;
    }

    public String getEntryId() { return entryId; }

    public void setEntryId(String entryId) { this.entryId = entryId; }

    public Date getEntryDate() { return entryDate; }

    public void setEntryDate(Date entryDate) { this.entryDate = entryDate; }

    public int getpCourseId() { return pCourseId; }

    public void setpCourseId(int pCourseId) { this.pCourseId = pCourseId;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
