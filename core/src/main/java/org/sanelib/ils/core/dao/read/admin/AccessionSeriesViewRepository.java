package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.AccessionSeriesMapper;
import org.sanelib.ils.core.domain.view.admin.AccessionSeriesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class AccessionSeriesViewRepository implements ViewService {

    @Autowired
    AccessionSeriesMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatements() {
        return "select * from accession_series";
    }

    public List<AccessionSeriesView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatements(), mapper);
    }
}
