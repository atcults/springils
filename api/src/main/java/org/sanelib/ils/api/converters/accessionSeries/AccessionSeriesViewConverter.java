package org.sanelib.ils.api.converters.accessionSeries;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.domain.view.admin.AccessionSeriesView;
import org.springframework.stereotype.Component;

@Component
public class AccessionSeriesViewConverter extends AbstractViewToDtoConverterImpl<AccessionSeriesDto, AccessionSeriesView> {

    @Override
    public AccessionSeriesDto convert(AccessionSeriesView accessionSeriesView) {

        AccessionSeriesDto accessionSeriesDto = new AccessionSeriesDto();

        accessionSeriesDto.setLibraryId(String.valueOf(accessionSeriesView.getLibraryId()));
        accessionSeriesDto.setCode(accessionSeriesView.getCode());
        accessionSeriesDto.setAccessionSeriesTypeName(accessionSeriesView.getAccessionSeriesType().toString());
        accessionSeriesDto.setPrefix(accessionSeriesView.getPrefix());
        accessionSeriesDto.setMaxNumber(String.valueOf(accessionSeriesView.getMaxNumber()));
        accessionSeriesDto.setMaxZero(String.valueOf(accessionSeriesView.getMaxZero()));

        return accessionSeriesDto;
    }
}
