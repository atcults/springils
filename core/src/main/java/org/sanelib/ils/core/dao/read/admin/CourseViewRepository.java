package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceBase;
import org.sanelib.ils.core.dao.read.admin.mapper.CourseMapper;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class CourseViewRepository extends ViewServiceBase {

    @Autowired
    CourseMapper mapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getStatements() {
        return Collections.singletonList("select * from course");
    }

    @Override
    public List<CourseView> getAll() throws Throwable {
        return viewService.loadQuery(getStatements().get(0), mapper);
    }
}
