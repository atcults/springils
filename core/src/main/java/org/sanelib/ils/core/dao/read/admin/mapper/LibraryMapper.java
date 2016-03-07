package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class LibraryMapper implements ViewMapper<LibraryView> {

    public LibraryView map(final DataResultSet rs) throws SQLException {

        final String viewName = "library";

        final LibraryView libraryView = new LibraryView();

        libraryView.setId(rs.getInt(viewName, "library_id"));
        libraryView.setName(rs.getString(viewName, "library_name"));
        libraryView.setCity(rs.getString(viewName, "city"));
        libraryView.setState(rs.getString(viewName, "state"));
        libraryView.setCountry(rs.getString(viewName, "country"));

        return libraryView;
    }
}

