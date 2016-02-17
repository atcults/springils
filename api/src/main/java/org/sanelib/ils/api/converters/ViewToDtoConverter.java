package org.sanelib.ils.api.converters;

import org.sanelib.ils.api.dto.Dto;
import org.sanelib.ils.core.domain.view.DomainView;

import java.util.List;

public interface ViewToDtoConverter<U extends Dto, T extends DomainView> {
    U convert(T domainView);
    List<U> convert(List<T> view);
}