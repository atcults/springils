package org.sanelib.ils.api.converters;

import org.sanelib.ils.api.dto.Dto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.exceptions.ProcessError;

public interface DtoToCommandConverter<T extends Dto> {
    ProcessCommand convert(T dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException;
}
