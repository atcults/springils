package org.sanelib.ils.api.converters.accessionSeries;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.AccessionSeriesView;
import org.springframework.stereotype.Component;

@Component
public class AccessionSeriesViewConverter implements ViewToDtoConverter<AccessionSeriesDto, AccessionSeriesView> {

    @Override
    public AccessionSeriesDto convert(AccessionSeriesView accessionSeriesView) {

        AccessionSeriesDto accessionSeriesDto = new AccessionSeriesDto();

        accessionSeriesDto.setLibraryId(String.valueOf(accessionSeriesView.getLibraryId()));
        accessionSeriesDto.setCode(accessionSeriesView.getSeriesName());
        accessionSeriesDto.setMaxNumber(String.valueOf(accessionSeriesView.getMaxNumber()));
        accessionSeriesDto.setMaxZero(String.valueOf(accessionSeriesView.getMaxZero()));
        accessionSeriesDto.setPrefix(accessionSeriesView.getPrefix());
        accessionSeriesDto.setTypeName(accessionSeriesView.getTypeName());

        return accessionSeriesDto;
    }
}
