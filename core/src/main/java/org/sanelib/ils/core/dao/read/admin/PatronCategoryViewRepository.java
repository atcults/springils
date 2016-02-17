package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.PatronCategoryMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class PatronCategoryViewRepository implements ViewService {

    @Autowired
    PatronCategoryMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    private String getStatement() {
        return "select * from patron_category";
    }

   public List<LibraryView> getAll() throws Throwable {
        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }
}