package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceBase;
import org.sanelib.ils.core.dao.read.admin.mapper.AuthorMapper;
import org.sanelib.ils.core.domain.view.DomainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class AuthorViewRepository extends ViewServiceBase{

    @Autowired
    AuthorMapper mapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getStatements() {
        return Collections.singletonList("select * from authors");
    }

    @Override
    public <T extends DomainView> List<T> getAll() throws Throwable {
        return viewService.loadQuery(getStatements().get(0), mapper);
    }
}
