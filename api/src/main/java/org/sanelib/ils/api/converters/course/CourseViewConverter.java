package org.sanelib.ils.api.converters.course;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.stereotype.Component;

@Component
public class CourseViewConverter extends AbstractViewToDtoConverterImpl<CourseDto, CourseView> {

    @Override
    public CourseDto convert(CourseView courseView) {
        CourseDto courseDto = new CourseDto();

        courseDto.setLibraryId(String.valueOf(courseView.getLibraryId()));
        courseDto.setId(String.valueOf(courseView.getId()));
        courseDto.setName(courseView.getCourseName());
        courseDto.setPromotedCourseId(String.valueOf(courseView.getPromotedCourseId()));

        return courseDto;
    }
}
