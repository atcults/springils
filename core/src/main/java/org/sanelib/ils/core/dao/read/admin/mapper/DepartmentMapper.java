package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DepartmentMapper implements ViewMapper<DepartmentView> {

    public DepartmentView map(final DataResultSet rs) throws SQLException {

        final String department = "dept";

        final DepartmentView view = new DepartmentView();

        view.setId(rs.getInt(department, "dept_id"));
        view.setLibraryId(rs.getInt(department, "library_id"));
        view.setDeptName(rs.getString(department, "dept_name"));
        view.setHodId(rs.getString(department, "hod_id"));

        return view;
    }
}

