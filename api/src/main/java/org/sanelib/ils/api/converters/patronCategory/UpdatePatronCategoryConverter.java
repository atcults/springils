package org.sanelib.ils.api.converters.patronCategory;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.commands.patronCategory.UpdatePatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdatePatronCategoryConverter extends AddPatronCategoryConverter {

    @Override
    public ProcessCommand convert(PatronCategoryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddPatronCategory addPatronCategory = (AddPatronCategory) super.convert(dto, processError);
        UpdatePatronCategory updatePatronCategory = new UpdatePatronCategory();
        ReflectionHelper.copy(addPatronCategory, updatePatronCategory);
        ConverterHelper.checkIdRequired(dto, updatePatronCategory, processError);
        return updatePatronCategory;
    }
}
