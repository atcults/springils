package org.sanelib.ils.core.dao.read.admin.mapper;


import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CourseMapper implements ViewMapper<CourseView> {

    @Override
    public CourseView map(DataResultSet rs) throws SQLException {

        final String viewName = "course";

        final CourseView courseView = new CourseView();

        courseView.setLibraryId(rs.getInt(viewName, "library_id"));
        courseView.setId(rs.getInt(viewName, "course_id"));
        courseView.setName(rs.getString(viewName, "course_name"));
        courseView.setPromotedCourseId(rs.getInt(viewName, "p_course_id"));

        return courseView;
    }
}
