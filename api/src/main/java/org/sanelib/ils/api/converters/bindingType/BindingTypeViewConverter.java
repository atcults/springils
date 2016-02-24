package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.springframework.stereotype.Component;

@Component
public class BindingTypeViewConverter  extends AbstractViewToDtoConverterImpl<BindingTypeDto, BindingTypeView> {

    @Override
    public BindingTypeDto convert(BindingTypeView bindingTypeView) {
        BindingTypeDto dto = new BindingTypeDto();

        dto.setLibraryId(String.valueOf(bindingTypeView.getLibraryId()));
        dto.setId(String.valueOf(bindingTypeView.getId()));
        dto.setBindType(bindingTypeView.getBindType());
        dto.setPrice(String.valueOf(bindingTypeView.getPrice()));
        return dto;
    }
}