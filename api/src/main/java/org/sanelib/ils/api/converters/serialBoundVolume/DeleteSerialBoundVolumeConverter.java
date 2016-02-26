package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.DeleteSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteSerialBoundVolumeConverter implements DtoToCommandConverter<SerialBoundVolumeDto> {
    public ProcessCommand convert(SerialBoundVolumeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteSerialBoundVolume command = new DeleteSerialBoundVolume();

        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        return command;
    }
}
