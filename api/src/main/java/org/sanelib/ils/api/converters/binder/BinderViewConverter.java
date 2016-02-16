package org.sanelib.ils.api.converters.binder;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.BinderView;
import org.springframework.stereotype.Component;

@Component
public class BinderViewConverter implements ViewToDtoConverter<BinderDto , BinderView>{
    @Override
    public BinderDto convert(BinderView binderView) {

        BinderDto binderDto = new BinderDto();

        binderDto.setLibraryId(String.valueOf(binderView.getLibraryId()));
        binderDto.setId(String.valueOf(binderView.getId()));
        binderDto.setBinderName(binderView.getBinderName());
        binderDto.setPrimaryAddress(binderView.getPrimaryAddress());
        binderDto.setSecondaryAddress(binderView.getSecondaryAddress());
        binderDto.setCity(binderView.getCity());
        binderDto.setState(binderView.getState());
        binderDto.setCountry(binderView.getCountry());
        binderDto.setPin(binderView.getPin());
        binderDto.setPrimaryPhoneNumber(binderView.getPrimaryPhoneNumber());
        binderDto.setSecondaryPhoneNumber(binderView.getSecondaryPhoneNumber());
        binderDto.setFax(binderView.getFax());
        binderDto.setEmail(binderView.getEmail());
        binderDto.setEntryId(binderView.getEntryId());
        binderDto.setEntryDate(DateHelper.toDateString(binderView.getEntryDate()));

        return binderDto;
    }
}
