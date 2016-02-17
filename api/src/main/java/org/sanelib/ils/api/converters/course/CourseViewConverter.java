package org.sanelib.ils.api.converters.course;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.stereotype.Component;

@Component
public class CourseViewConverter implements ViewToDtoConverter<CourseDto, CourseView> {
    @Override
    public CourseDto convert(CourseView courseView) {
        CourseDto courseDto = new CourseDto();

        courseDto.setLibraryId(String.valueOf(courseView.getLibraryId()));
        courseDto.setId(String.valueOf(courseView.getId()));
        courseDto.setName(courseView.getCourseName());
        courseDto.setHodId(String.valueOf(courseView.getHodId()));
        courseDto.setEntryId(courseView.getEntryId());
        courseDto.setpCourseId(String.valueOf(courseView.getpCourseId()));

        return courseDto;
    }
}
