package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.HolidayView;
import org.sanelib.ils.core.enums.HolidayType;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class HolidayMapper implements ViewMapper<HolidayView> {

    public HolidayView map(final DataResultSet rs) throws SQLException {
        final String viewName = "adm_co_holiday";

        final HolidayView view = new HolidayView();

        view.setLibraryId(rs.getInt(viewName, "library_id"));
        view.setFiscalYearId(rs.getInt(viewName, "fiscal_year"));
        view.setHolidayType(HolidayType.getByValue(rs.getString(viewName, "holi_type")));
        view.setHolidayDate(rs.getDate(viewName, "holiday"));
        view.setNote(rs.getString(viewName, "note"));

        return view;
    }
}

