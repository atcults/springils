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

        final String accessionSeries = "accession_series";

        final AccessionSeriesView accessionSeriesView = new AccessionSeriesView();

        accessionSeriesView.setLibraryId(rs.getInt(accessionSeries, "library_id"));
        accessionSeriesView.setSeriesName(rs.getString(accessionSeries, "series_name"));
        accessionSeriesView.setAccessionSeriesType(AccessionSeriesType.getByValue(rs.getString(accessionSeries , "fixed_variable")));
        accessionSeriesView.setPrefix(rs.getString(accessionSeries, "prefix"));
        accessionSeriesView.setMaxNumber(rs.getInt(accessionSeries, "max_number"));
        accessionSeriesView.setMaxZero(rs.getInt(accessionSeries, "max_zero"));

        return accessionSeriesView;
    }
}
