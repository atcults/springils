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
    private String entryId;
    private Integer promotedCourseId;

    public String getEntryId() { return entryId; }

    public void setEntryId(String entryId) { this.entryId = entryId; }

    public Integer getPromotedCourseId() { return promotedCourseId; }

    public void setPromotedCourseId(Integer promotedCourseId) { this.promotedCourseId = promotedCourseId;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
