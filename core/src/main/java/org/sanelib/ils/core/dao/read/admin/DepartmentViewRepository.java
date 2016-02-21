package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.DepartmentMapper;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class DepartmentViewRepository implements ViewService {

    @Autowired
    DepartmentMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    public String getStatement() {
        return "select * from dept";
    }

    public List<DepartmentView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }

}