package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.CourseMapper;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class CourseViewRepository implements ViewService  {

    @Autowired
    CourseMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatement() {
        return "select * from course";
    }

    public List<CourseView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }
}
