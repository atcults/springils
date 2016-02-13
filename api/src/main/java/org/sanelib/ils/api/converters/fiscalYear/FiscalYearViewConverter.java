package org.sanelib.ils.api.converters.fiscalYear;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.fiscalYear.FiscalYearDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.FiscalYearView;
import org.springframework.stereotype.Component;

@Component
public class FiscalYearViewConverter implements ViewToDtoConverter<FiscalYearDto , FiscalYearView> {
    @Override
    public FiscalYearDto convert(FiscalYearView fiscalYearView) {

        FiscalYearDto dto = new FiscalYearDto();

        dto.setId(String.valueOf(fiscalYearView.getId()));
        dto.setStartYear(String.valueOf(fiscalYearView.getStartYear()));
        dto.setEndYear(String.valueOf(fiscalYearView.getEndYear()));
        dto.setStartDate(DateHelper.toDateString(fiscalYearView.getStartDate()));
        dto.setEndDate(DateHelper.toDateString(fiscalYearView.getEndDate()));

        return dto;
    }
}
