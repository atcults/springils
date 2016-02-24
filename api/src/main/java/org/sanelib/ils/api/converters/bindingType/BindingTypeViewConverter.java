package org.sanelib.ils.api.converters.bindingType;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BindingTypeViewConverter  extends AbstractViewToDtoConverterImpl<BindingTypeDto, BindingTypeView> {


    @Override
    public List<BindingTypeDto> convert(List<BindingTypeView> bindingTypeView) {
        List<BindingTypeDto> bindingTypeDtos = new ArrayList<>();

        for(BindingTypeView view : bindingTypeView) {

            BindingTypeDto dto = new BindingTypeDto();

            dto.setLibraryId(String.valueOf(view.getLibraryId()));
            dto.setId(String.valueOf(view.getId()));
            dto.setBindType(view.getBindType());
            dto.setPrice(String.valueOf(view.getPrice()));

            bindingTypeDtos.add(dto);
        }
        return bindingTypeDtos;
    }

}