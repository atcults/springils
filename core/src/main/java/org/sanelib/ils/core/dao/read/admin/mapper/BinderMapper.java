package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.BinderView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class BinderMapper implements ViewMapper<BinderView>{
    @Override
    public BinderView map(DataResultSet rs) throws SQLException {

        final String viewName = "cir_co_binder";

        final BinderView binderView = new BinderView();

        binderView.setLibraryId(rs.getInt(viewName , "library_id"));
        binderView.setId(rs.getInt(viewName , "binder_id"));
        binderView.setName(rs.getString(viewName , "binder_name"));
        binderView.setPrimaryAddress(rs.getString(viewName , "address1"));
        binderView.setSecondaryAddress(rs.getString(viewName , "address2"));
        binderView.setCity(rs.getString(viewName , "city"));
        binderView.setState(rs.getString(viewName , "state"));
        binderView.setCountry(rs.getString(viewName , "country"));
        binderView.setPin(rs.getString(viewName , "pin"));
        binderView.setPrimaryPhoneNumber(rs.getString(viewName , "phone1"));
        binderView.setSecondaryPhoneNumber(rs.getString(viewName , "phone2"));
        binderView.setFax(rs.getString(viewName , "fax"));
        binderView.setEmail(rs.getString(viewName , "email"));

        return binderView;
    }
}
