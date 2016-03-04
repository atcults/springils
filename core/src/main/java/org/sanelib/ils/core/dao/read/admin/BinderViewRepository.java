package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.BinderMapper;
import org.sanelib.ils.core.domain.view.admin.BinderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class BinderViewRepository implements ViewService {

    @Autowired
    BinderMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatements() {
        return "select * from cir_co_binder";
    }

    public List<BinderView> getAllBinders() throws Throwable {
        return viewServiceHelper.loadQuery(getStatements(), mapper);
    }
}
