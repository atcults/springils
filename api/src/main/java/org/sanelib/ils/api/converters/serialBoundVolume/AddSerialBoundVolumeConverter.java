package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddSerialBoundVolumeConverter implements DtoToCommandConverter<SerialBoundVolumeDto> {

    @Override
    public ProcessCommand convert(SerialBoundVolumeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddSerialBoundVolume command = new AddSerialBoundVolume();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        command.setName(dto.getName());
        command.setColor(dto.getColor());
        command.setPrice(Double.valueOf(dto.getPrice()));
        command.setEntryId(dto.getEntryId());
        command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));

        return command;
    }
}
