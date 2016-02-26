package org.sanelib.ils.api.converters.agency;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.agency.AddAgency;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateAgencyConverter extends AddAgencyConverter {

    @Override
    public ProcessCommand convert(AgencyDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddAgency addAgency = (AddAgency) super.convert(dto, processError);
        UpdateAgency updateAgency = new UpdateAgency();

        ReflectionHelper.copy(addAgency, updateAgency);
        ConverterHelper.checkIdRequired(dto, updateAgency, processError);

        return updateAgency;
    }
}
