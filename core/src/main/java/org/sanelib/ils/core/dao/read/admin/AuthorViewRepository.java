package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.AuthorMapper;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class AuthorViewRepository implements ViewService {

    @Autowired
    AuthorMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatement() {
        return "select * from authors";
    }

    public List<AuthorView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }
}
