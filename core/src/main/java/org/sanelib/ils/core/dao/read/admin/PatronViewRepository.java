package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.PatronMapper;
import org.sanelib.ils.core.domain.view.admin.PatronView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class PatronViewRepository implements ViewService {

    @Autowired
    PatronMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatement() {
        return "select * from patron";
    }

    public List<PatronView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }
}