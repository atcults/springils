package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.FiscalYearView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class FiscalYearMapper implements ViewMapper<FiscalYearView> {

    @Override
    public FiscalYearView map(DataResultSet rs) throws SQLException {

        final String viewName="acc_fiscal_year";

        final FiscalYearView fiscalYearView = new FiscalYearView();

        fiscalYearView.setLibraryId(rs.getInt(viewName , "library_id"));
        fiscalYearView.setId(rs.getInt(viewName, "fiscal_year"));
        fiscalYearView.setStartYear(rs.getInt(viewName, "year1"));
        fiscalYearView.setEndYear(rs.getInt(viewName, "year2"));
        fiscalYearView.setStartDate(rs.getDate(viewName, "start_date"));
        fiscalYearView.setEndDate(rs.getDate(viewName, "end_date"));

        return fiscalYearView;
    }
}
