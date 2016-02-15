package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.stereotype.Component;

@Component
public class SerialBoundVolumeViewConverter implements ViewToDtoConverter<SerialBoundVolumeDto, SerialBoundVolumeView> {

    @Override
    public SerialBoundVolumeDto convert(SerialBoundVolumeView serialBoundVolumeView) {

        SerialBoundVolumeDto serialBoundVolumeDto=new SerialBoundVolumeDto();

        serialBoundVolumeDto.setLibraryId(String.valueOf(serialBoundVolumeView.getLibraryId()));
        serialBoundVolumeDto.setId(String.valueOf(serialBoundVolumeView.getId()));
        serialBoundVolumeDto.setColor(serialBoundVolumeView.getColor());
        serialBoundVolumeDto.setEntryDate(DateHelper.toDateString(serialBoundVolumeView.getEntryDate()));
        serialBoundVolumeDto.setEntryId(serialBoundVolumeView.getEntryId());
        serialBoundVolumeDto.setName(serialBoundVolumeView.getName());
        serialBoundVolumeDto.setPrice(String.valueOf(serialBoundVolumeView.getPrice()));


        return serialBoundVolumeDto;
    }
}
