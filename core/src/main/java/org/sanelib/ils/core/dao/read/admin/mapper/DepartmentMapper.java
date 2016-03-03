package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DepartmentMapper implements ViewMapper<DepartmentView> {

    public DepartmentView map(final DataResultSet rs) throws SQLException {

        final String viewName = "dept";

        final DepartmentView departmentView = new DepartmentView();

        departmentView.setId(rs.getInt(viewName, "dept_id"));
        departmentView.setLibraryId(rs.getInt(viewName, "library_id"));
        departmentView.setName(rs.getString(viewName, "dept_name"));
        departmentView.setHodId(rs.getString(viewName, "hod_id"));

        return departmentView;
    }
}

