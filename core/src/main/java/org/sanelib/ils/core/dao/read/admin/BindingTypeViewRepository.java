package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.BindingTypeMapper;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class BindingTypeViewRepository implements ViewService {

    @Autowired
    BindingTypeMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatements() {
        return "select * from cir_co_bind_types";
    }

   public List<BindingTypeView> getAll() throws Throwable {

        String query = getStatements();

        return viewServiceHelper.loadQuery(query, mapper);

    }
}