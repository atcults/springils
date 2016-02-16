package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.springframework.stereotype.Component;

@Component
public class BindingTypeViewConverter implements ViewToDtoConverter<BindingTypeDto, BindingTypeView> {

    @Override
    public BindingTypeDto convert(BindingTypeView bindingTypeView) {

        BindingTypeDto dto = new BindingTypeDto();

        dto.setLibraryId(String.valueOf(bindingTypeView.getLibraryId()));
        dto.setId(String.valueOf(bindingTypeView.getId()));
        dto.setBindType(bindingTypeView.getBindType());
        dto.setPrice(String.valueOf(bindingTypeView.getPrice()));
        dto.setEntryId(bindingTypeView.getEntryId());
        dto.setEntryDate(DateHelper.toDateString(bindingTypeView.getEntryDate()));

        return dto;
    }
}