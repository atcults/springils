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

        final String course = "course";

        final CourseView courseView=new CourseView();

        courseView.setLibraryId(rs.getInt(course,"library_id"));
        courseView.setId(rs.getInt(course,"course_id"));
        courseView.setCourseName(rs.getString(course,"course_name"));
        courseView.setHodId(rs.getDouble(course,"hod_id"));
        courseView.setEntryId(rs.getString(course,"entry_id"));
        courseView.setEntryDate(rs.getDate(course,"entry_date"));
        courseView.setpCourseId(rs.getInt(course,"p_course_id"));

        return courseView;
    }
}
