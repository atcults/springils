package org.sanelib.ils.api.converters.department;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.stereotype.Component;

@Component
public class DepartmentViewConverter extends AbstractViewToDtoConverterImpl<DepartmentDto, DepartmentView> {

    @Override
    public DepartmentDto convert(DepartmentView departmentView) {
        DepartmentDto dto = new DepartmentDto();

        dto.setLibraryId(String.valueOf(departmentView.getLibraryId()));
        dto.setId(String.valueOf(departmentView.getId()));
        dto.setName(departmentView.getDeptName());
        dto.setHodId(departmentView.getHodId());

        return dto;
    }
}