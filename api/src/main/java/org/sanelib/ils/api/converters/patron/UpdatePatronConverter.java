package org.sanelib.ils.api.converters.patron;


import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patron.AddPatron;
import org.sanelib.ils.core.commands.patron.UpdatePatron;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdatePatronConverter extends AddPatronConverter {

    @Override
    public ProcessCommand convert(PatronDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddPatron addPatron = (AddPatron) super.convert(dto, processError);

        UpdatePatron updatePatron = new UpdatePatron();

        ReflectionHelper.copy(addPatron, updatePatron);
        ConverterHelper.checkCodeRequired(dto, updatePatron, processError);

        return updatePatron;
    }
}
