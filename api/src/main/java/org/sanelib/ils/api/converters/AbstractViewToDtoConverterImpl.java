package org.sanelib.ils.api.converters;

import org.apache.commons.lang3.NotImplementedException;
import org.sanelib.ils.api.dto.Dto;
import org.sanelib.ils.core.domain.view.DomainView;

import java.util.List;

public class AbstractViewToDtoConverterImpl<U extends Dto, T extends DomainView> implements ViewToDtoConverter<U, T> {

    @Override
    public U convert(T domainView) {
        throw new NotImplementedException("Please use List converter");
    }

    @Override
    public List<U> convert(List<T> view) {
        throw new NotImplementedException("Please use row converter");
    }
}
