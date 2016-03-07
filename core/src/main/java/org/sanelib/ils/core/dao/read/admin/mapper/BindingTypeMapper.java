package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class BindingTypeMapper implements ViewMapper<BindingTypeView> {

    public BindingTypeView map(final DataResultSet rs) throws SQLException {

        final String viewName = "cir_co_bind_types";

        final BindingTypeView bindingTypeView = new BindingTypeView();

        bindingTypeView.setLibraryId(rs.getInt(viewName, "library_id"));
        bindingTypeView.setId(rs.getInt(viewName, "bind_type_id"));
        bindingTypeView.setBindType(rs.getString(viewName, "bind_type"));
        bindingTypeView.setPrice(rs.getDouble(viewName, "price"));

        return bindingTypeView;
    }
}

