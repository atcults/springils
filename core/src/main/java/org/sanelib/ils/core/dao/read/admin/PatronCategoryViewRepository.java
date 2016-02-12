package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceBase;
import org.sanelib.ils.core.dao.read.admin.mapper.LibraryMapper;
import org.sanelib.ils.core.dao.read.admin.mapper.PatronCategoryMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class PatronCategoryViewRepository extends ViewServiceBase {

    @Autowired
    PatronCategoryMapper mapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getStatements() {
        return Collections.singletonList("select * from patron_category");
    }

   public List<LibraryView> getAll() throws Throwable {
        return viewService.loadQuery(getStatements().get(0), mapper);
    }
}