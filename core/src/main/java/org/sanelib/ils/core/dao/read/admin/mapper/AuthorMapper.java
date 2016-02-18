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

        final String author= "authors";

        final AuthorView authorView = new AuthorView();

        authorView.setCode(rs.getString(author , "au_id"));
        authorView.setLastName(rs.getString(author , "au_lname"));
        authorView.setFirstName(rs.getString(author , "au_fname"));
        authorView.setPhone(rs.getString(author , "phone"));
        authorView.setAddress(rs.getString(author , "address"));
        authorView.setCity(rs.getString(author , "city"));
        authorView.setState(rs.getString(author , "state"));
        authorView.setZipCode(rs.getString(author , "zip"));
        authorView.setContract(rs.getBoolean(author , "contract"));

        return authorView;
    }
}
