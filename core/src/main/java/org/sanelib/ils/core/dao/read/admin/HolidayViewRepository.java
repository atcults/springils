package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.HolidayMapper;
import org.sanelib.ils.core.domain.view.admin.HolidayView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class HolidayViewRepository implements ViewService {

    @Autowired
    HolidayMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    public String getStatement() {
        return "select * from adm_co_holiday";
    }

    public List<HolidayView> getHolidaysForFiscalYear(Integer libraryId, Integer fiscalYearId) {

        String query = getStatement() + " where library_id = ? and fiscal_year = ? order by holiday";

        return viewServiceHelper.loadQuery(query, new Object[]{libraryId, fiscalYearId}, mapper);
    }
}