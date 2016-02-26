package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.stereotype.Component;

@Component
public class SerialBoundVolumeViewConverter extends AbstractViewToDtoConverterImpl<SerialBoundVolumeDto, SerialBoundVolumeView> {

    @Override
    public SerialBoundVolumeDto convert(SerialBoundVolumeView serialBoundVolumeView) {

            SerialBoundVolumeDto serialBoundVolumeDto = new SerialBoundVolumeDto();

            serialBoundVolumeDto.setLibraryId(String.valueOf(serialBoundVolumeView.getLibraryId()));
            serialBoundVolumeDto.setId(String.valueOf(serialBoundVolumeView.getId()));
            serialBoundVolumeDto.setColor(serialBoundVolumeView.getColor());
            serialBoundVolumeDto.setName(serialBoundVolumeView.getName());
            serialBoundVolumeDto.setPrice(String.valueOf(serialBoundVolumeView.getPrice()));

            return serialBoundVolumeDto;
    }
}
