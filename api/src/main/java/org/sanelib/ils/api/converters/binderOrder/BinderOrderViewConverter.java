package org.sanelib.ils.api.converters.binderOrder;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.BinderOrderView;
import org.springframework.stereotype.Component;

@Component
public class BinderOrderViewConverter extends AbstractViewToDtoConverterImpl<BinderOrderDto, BinderOrderView> {

    @Override
    public BinderOrderDto convert(BinderOrderView binderOrderView) {

        BinderOrderDto dto = new BinderOrderDto();

        dto.setLibraryId(String.valueOf(binderOrderView.getLibraryId()));
        dto.setId(String.valueOf(binderOrderView.getId()));
        dto.setBinderId(String.valueOf(binderOrderView.getBinderId()));
        dto.setOrderDate(DateHelper.toDateString(binderOrderView.getOrderDate()));
        dto.setDueDate(DateHelper.toDateString(binderOrderView.getDueDate()));
        dto.setReturnedDate(DateHelper.toDateString(binderOrderView.getReturnedDate()));
        dto.setFormLetterNo(binderOrderView.getFormLetterNo());
        dto.setSubject(binderOrderView.getSubject());
        dto.setContent(binderOrderView.getContent());
        dto.setMailStatus(binderOrderView.isMailStatus());
        dto.setPrintStatus(binderOrderView.isPrintStatus());
        dto.setStatus(binderOrderView.getStatus());

        return dto;
    }
}