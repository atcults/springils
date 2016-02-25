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

        final String fiscalYear="acc_fiscal_year";

        final FiscalYearView fiscalYearView = new FiscalYearView();

        fiscalYearView.setId(rs.getInt(fiscalYear , "fiscal_year"));
        fiscalYearView.setStartYear(rs.getInt(fiscalYear , "year1"));
        fiscalYearView.setEndYear(rs.getInt(fiscalYear , "year2"));
        fiscalYearView.setStartDate(rs.getDate(fiscalYear , "start_date"));
        fiscalYearView.setEndDate(rs.getDate(fiscalYear , "end_date"));

        return fiscalYearView;
    }
}
