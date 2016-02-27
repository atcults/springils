package org.sanelib.ils.api.converters.binder;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.core.domain.view.admin.BinderView;
import org.springframework.stereotype.Component;

@Component
public class BinderViewConverter extends AbstractViewToDtoConverterImpl<BinderDto , BinderView> {

    @Override
    public BinderDto convert(BinderView binderView) {

        BinderDto binderDto = new BinderDto();

        binderDto.setLibraryId(String.valueOf(binderView.getLibraryId()));
        binderDto.setId(String.valueOf(binderView.getId()));
        binderDto.setName(binderView.getBinderName());
        binderDto.setAddressLine1(binderView.getPrimaryAddress());
        binderDto.setAddressLine2(binderView.getSecondaryAddress());
        binderDto.setCity(binderView.getCity());
        binderDto.setState(binderView.getState());
        binderDto.setCountry(binderView.getCountry());
        binderDto.setPin(binderView.getPin());
        binderDto.setPrimaryPhone(binderView.getPrimaryPhoneNumber());
        binderDto.setSecondaryPhone(binderView.getSecondaryPhoneNumber());
        binderDto.setFax(binderView.getFax());
        binderDto.setEmail(binderView.getEmail());

        return binderDto;
    }
}
