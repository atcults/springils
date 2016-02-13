package org.sanelib.ils.api.converters.patronCategory;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.core.domain.view.admin.PatronCategoryView;
import org.springframework.stereotype.Component;

@Component
public class PatronCategoryViewConverter implements ViewToDtoConverter<PatronCategoryDto, PatronCategoryView> {

    @Override
    public PatronCategoryDto convert(PatronCategoryView libraryView) {
        PatronCategoryDto dto = new PatronCategoryDto();
        dto.setId(String.valueOf(libraryView.getId()));
        dto.setName(libraryView.getName());
        dto.setLibraryId(String.valueOf(libraryView.getLibraryId()));
        dto.setAllowILLFromNet(libraryView.isAllowILLFromNet());
        dto.setAllowRenewalFromNet(libraryView.isAllowRenewalFromNet());
        dto.setAllowMultipleCopies(libraryView.isAllowMultipleCopies());
        dto.setOverallLoanLimit(String.valueOf(libraryView.getOverallLoanLimit()));
        dto.setAcqWorkflow(libraryView.getAcqWorkflow());
        return dto;
    }
}