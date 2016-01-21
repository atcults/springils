package org.sanelib.ils.api.converters.serialBoundVolume;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.commands.serialBoundVolume.UpdateSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateSerialBoundVolumeConverter extends AddSerialBoundVolumeConverter {

    @Override
    public ProcessCommand convert(SerialBoundVolumeDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddSerialBoundVolume addSerialBoundVolume = (AddSerialBoundVolume) super.convert(dto, processError);

        UpdateSerialBoundVolume updateSerialBoundVolume = new UpdateSerialBoundVolume();
        ReflectionHelper.copy(addSerialBoundVolume, updateSerialBoundVolume);

        ConverterHelper.checkIdRequired(dto, updateSerialBoundVolume, processError);

        return updateSerialBoundVolume;
    }
}
