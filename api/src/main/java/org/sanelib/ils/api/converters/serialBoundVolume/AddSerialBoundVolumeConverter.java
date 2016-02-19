package org.sanelib.ils.api.converters.serialBoundVolume;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
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

        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.serialBoundVolume.name");
        } else{
            command.setName(dto.getName());
        }

        command.setColor(dto.getColor());
        command.setPrice(Double.valueOf(dto.getPrice()));
        command.setEntryId(dto.getEntryId());

        return command;
    }
}
