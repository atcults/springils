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

        accessionSeriesView.setLibraryId(rs.getInt(accession_series, "library_id"));
        accessionSeriesView.setSeriesName(rs.getString(accession_series, "series_name"));
        accessionSeriesView.setAccessionSeriesType(AccessionSeriesType.getByValue(rs.getString(accession_series , "fixed_variable")));
        accessionSeriesView.setPrefix(rs.getString(accession_series, "prefix"));
        accessionSeriesView.setMaxNumber(rs.getInt(accession_series, "max_number"));
        accessionSeriesView.setMaxZero(rs.getInt(accession_series, "max_zero"));

        return accessionSeriesView;
    }
}
