package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.BinderOrderMapper;
import org.sanelib.ils.core.domain.view.admin.BinderOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class BinderOrderViewRepository implements ViewService {

    @Autowired
    BinderOrderMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatements() {
        return "select * from cir_binder_order";
    }

   public List<BinderOrderView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatements(), mapper);
    }
}