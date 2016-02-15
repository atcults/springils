package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.springframework.stereotype.Component;

@Component
public class BindingTypeViewConverter implements ViewToDtoConverter<BindingTypeDto, BindingTypeView> {

    @Override
    public BindingTypeDto convert(BindingTypeView libraryView) {
        BindingTypeDto dto = new BindingTypeDto();
        dto.setLibraryId(String.valueOf(libraryView.getLibraryId()));
        dto.setId(String.valueOf(libraryView.getId()));
        dto.setBindType(libraryView.getBindType());
        dto.setPrice(String.valueOf(libraryView.getPrice()));
        dto.setEntryId(libraryView.getEntryId());
        dto.setEntryDate(DateHelper.toDateString(libraryView.getEntryDate()));
        return dto;
    }
}