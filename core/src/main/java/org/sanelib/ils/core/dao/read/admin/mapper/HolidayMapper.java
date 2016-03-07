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

        final HolidayView holidayView = new HolidayView();

        holidayView.setLibraryId(rs.getInt(viewName, "library_id"));
        holidayView.setFiscalYearId(rs.getInt(viewName, "fiscal_year"));
        holidayView.setHolidayType(HolidayType.getByValue(rs.getString(viewName, "holi_type")));
        holidayView.setHolidayDate(rs.getDate(viewName, "holiday"));
        holidayView.setNote(rs.getString(viewName, "note"));

        return holidayView;
    }
}

