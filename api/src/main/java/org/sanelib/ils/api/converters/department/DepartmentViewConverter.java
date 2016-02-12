package org.sanelib.ils.api.converters.department;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.stereotype.Component;

@Component
public class DepartmentViewConverter implements ViewToDtoConverter<DepartmentDto, DepartmentView> {

    @Override
    public DepartmentDto convert(DepartmentView departmentView) {
        DepartmentDto dto = new DepartmentDto();

        dto.setId(String.valueOf(departmentView.getId()));
        dto.setLibraryId(String.valueOf(departmentView.getLibraryId()));
        dto.setDeptName(departmentView.getDeptName());
        dto.setHodId(departmentView.getHodId());
        dto.setEntryId(departmentView.getEntryId());
        dto.setEntryDate(departmentView.getEntryDate());

        return dto;
    }
}