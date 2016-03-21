package org.sanelib.ils.api.dto.course;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class CourseDto implements DtoWithId, DtoWithLibraryId {

    private String id;
    private String libraryId;
    private String name;
    private String promotedCourseId;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromotedCourseId() {
        return promotedCourseId;
    }

    public void setPromotedCourseId(String promotedCourseId) {
        this.promotedCourseId = promotedCourseId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
