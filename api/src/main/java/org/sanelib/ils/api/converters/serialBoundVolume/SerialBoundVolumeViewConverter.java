package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SerialBoundVolumeViewConverter extends AbstractViewToDtoConverterImpl<SerialBoundVolumeDto, SerialBoundVolumeView> {

    @Override
    public List<SerialBoundVolumeDto> convert(List<SerialBoundVolumeView> serialBoundVolumeView) {
        List<SerialBoundVolumeDto> boundVolumeDtos = new ArrayList<>();

        for(SerialBoundVolumeView view : serialBoundVolumeView) {
            SerialBoundVolumeDto serialBoundVolumeDto = new SerialBoundVolumeDto();

            serialBoundVolumeDto.setLibraryId(String.valueOf(view.getLibraryId()));
            serialBoundVolumeDto.setId(String.valueOf(view.getId()));
            serialBoundVolumeDto.setColor(view.getColor());
            serialBoundVolumeDto.setEntryId(view.getEntryId());
            serialBoundVolumeDto.setName(view.getName());
            serialBoundVolumeDto.setPrice(String.valueOf(view.getPrice()));

            boundVolumeDtos.add(serialBoundVolumeDto);
        }
        return boundVolumeDtos;
    }
}
