package org.sanelib.ils.api.converters.binderOrder;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.BinderOrderView;
import org.springframework.stereotype.Component;

@Component
public class BinderOrderViewConverter implements ViewToDtoConverter<BinderOrderDto, BinderOrderView> {

    @Override
    public BinderOrderDto convert(BinderOrderView libraryView) {
        BinderOrderDto dto = new BinderOrderDto();
        dto.setLibraryId(String.valueOf(libraryView.getLibraryId()));
        dto.setId(String.valueOf(libraryView.getId()));
        dto.setBinderId(String.valueOf(libraryView.getBinderId()));
        dto.setOrderDate(DateHelper.toDateString(libraryView.getOrderDate()));
        dto.setDueDate(DateHelper.toDateString(libraryView.getDueDate()));
        dto.setReturnedDate(DateHelper.toDateString(libraryView.getReturnedDate()));
        dto.setFormLetterNo(libraryView.getFormLetterNo());
        dto.setSubject(libraryView.getSubject());
        dto.setContent(libraryView.getContent());
        dto.setMailStatus(libraryView.isMailStatus());
        dto.setPrintStatus(libraryView.isPrintStatus());
        dto.setStatus(libraryView.getStatus());
        dto.setEntryId(libraryView.getEntryId());
        return dto;
    }
}