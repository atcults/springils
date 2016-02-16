package org.sanelib.ils.core.dao.read.admin.mapper;


import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.AccessionSeriesView;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AccessionSeriesMapper implements ViewMapper<AccessionSeriesView> {

    @Override
    public AccessionSeriesView map(DataResultSet rs) throws SQLException {

        final String accession_series = "accession_series";

        final AccessionSeriesView accessionSeriesView = new AccessionSeriesView();

        accessionSeriesView.setSeriesName(rs.getString(accession_series, "series_name"));
        accessionSeriesView.setLibraryId(rs.getInt(accession_series,"library_id"));
        accessionSeriesView.setMaxNumber(rs.getInt(accession_series,"max_number"));
        accessionSeriesView.setMaxZero(rs.getInt(accession_series,"max_zero"));
        accessionSeriesView.setTypeName(AccessionSeriesType.getByValue(rs.getString(accession_series , "fixed_variable")));
        accessionSeriesView.setEntryDate(rs.getDate(accession_series,"entry_date"));
        accessionSeriesView.setPrefix(rs.getString(accession_series,"prefix"));
        accessionSeriesView.setEntryId(rs.getString(accession_series,"entry_id"));
        accessionSeriesView.setEntryLibraryId(rs.getInt(accession_series, "entry_library_id"));

        return accessionSeriesView;
    }
}
