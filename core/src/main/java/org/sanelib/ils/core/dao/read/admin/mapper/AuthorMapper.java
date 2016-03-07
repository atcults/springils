package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AuthorMapper implements ViewMapper<AuthorView>{

    @Override
    public AuthorView map(final DataResultSet rs) throws SQLException {

        final String viewName = "authors";

        final AuthorView authorView = new AuthorView();

        authorView.setCode(rs.getString(viewName, "au_id"));
        authorView.setLastName(rs.getString(viewName, "au_lname"));
        authorView.setFirstName(rs.getString(viewName, "au_fname"));
        authorView.setPhone(rs.getString(viewName, "phone"));
        authorView.setAddress(rs.getString(viewName, "address"));
        authorView.setCity(rs.getString(viewName, "city"));
        authorView.setState(rs.getString(viewName, "state"));
        authorView.setZipCode(rs.getString(viewName, "zip"));
        authorView.setContract(rs.getBoolean(viewName, "contract"));

        return authorView;
    }
}
