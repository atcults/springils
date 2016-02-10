package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class LibraryMapper implements ViewMapper<LibraryView> {

    public LibraryView map(final DataResultSet rs) throws SQLException {

        final String library = "library";
        final LibraryView libraryView = new LibraryView();
        libraryView.setId(rs.getInt(library, "libraryId"));
        libraryView.setName(rs.getString(library, "library_name"));
        libraryView.setCity(rs.getString(library, "city"));
        libraryView.setState(rs.getString(library, "state"));
        libraryView.setCountry(rs.getString(library, "country"));
        return libraryView;
    }
}

