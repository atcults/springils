package org.sanelib.ils.api.converters.materialType;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.core.domain.view.admin.MaterialTypeView;
import org.springframework.stereotype.Component;

@Component
public class MaterialTypeViewConverter extends AbstractViewToDtoConverterImpl<MaterialTypeDto , MaterialTypeView>{

    @Override
    public MaterialTypeDto convert(MaterialTypeView materialTypeView){
        MaterialTypeDto dto = new MaterialTypeDto();

        dto.setMaterialType(materialTypeView.getMaterialTypeName());

        return dto;
    }
}
