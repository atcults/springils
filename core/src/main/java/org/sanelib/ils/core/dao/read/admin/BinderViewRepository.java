package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceBase;
import org.sanelib.ils.core.dao.read.admin.mapper.BinderMapper;
import org.sanelib.ils.core.domain.view.admin.BinderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class BinderViewRepository extends ViewServiceBase {

    @Autowired
    BinderMapper mapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getStatements() {
        return Collections.singletonList("select * from cir_co_binder");
    }

    @Override
    public List<BinderView> getAll() throws Throwable {
        return viewService.loadQuery(getStatements().get(0), mapper);
    }
}
