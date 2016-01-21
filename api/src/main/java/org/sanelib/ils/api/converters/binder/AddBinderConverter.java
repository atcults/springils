package org.sanelib.ils.api.converters.binder;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddBinderConverter implements DtoToCommandConverter<BinderDto> {

    @Override
    public ProcessCommand convert(BinderDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddBinder command = new AddBinder();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        command.setBinderName(dto.getBinderName());
        command.setPrimaryAddress(dto.getPrimaryAddress());
        command.setSecondaryAddress(dto.getSecondaryAddress());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setPin(dto.getPin());
        command.setPrimaryPhoneNumber(dto.getPrimaryPhoneNumber());
        command.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
        command.setFax(dto.getFax());
        command.setEmail(dto.getEmail());
        command.setEntryId(dto.getEntryId());
        command.setEntryDate(DateHelper.fromDateString(dto.getEntryDate()));

        return command;
    }
}
