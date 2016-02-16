package org.sanelib.ils.api.converters.patronCategory;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.DeletePatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeletePatronCategoryConverter implements DtoToCommandConverter<PatronCategoryDto> {
    public ProcessCommand convert(PatronCategoryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeletePatronCategory command = new DeletePatronCategory();
        ConverterHelper.checkIdRequired(dto, command, processError);
        ConverterHelper.checkLibraryIdRequired(dto, command, processError);
       return command;
    }
}
