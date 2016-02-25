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

        final String binder = "cir_co_binder";

        final BinderView binderView = new BinderView();

        binderView.setLibraryId(rs.getInt(binder , "library_id"));
        binderView.setId(rs.getInt(binder , "binder_id"));
        binderView.setBinderName(rs.getString(binder , "binder_name"));
        binderView.setPrimaryAddress(rs.getString(binder , "address1"));
        binderView.setSecondaryAddress(rs.getString(binder , "address2"));
        binderView.setCity(rs.getString(binder , "city"));
        binderView.setState(rs.getString(binder , "state"));
        binderView.setCountry(rs.getString(binder , "country"));
        binderView.setPin(rs.getString(binder , "pin"));
        binderView.setPrimaryPhoneNumber(rs.getString(binder , "phone1"));
        binderView.setSecondaryPhoneNumber(rs.getString(binder , "phone2"));
        binderView.setFax(rs.getString(binder , "fax"));
        binderView.setEmail(rs.getString(binder , "email"));

        return binderView;
    }
}
