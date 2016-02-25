package org.sanelib.ils.api.converters.circulationMatrix;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.DeleteCirculationMatrix;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteCirculationMatrixConverter implements DtoToCommandConverter<CirculationMatrixDto> {

    @Override
    public ProcessCommand convert(CirculationMatrixDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteCirculationMatrix command = new DeleteCirculationMatrix();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        if(Strings.isNullOrEmpty(dto.getPatronCategoryId())) {
            processError.addError("common.field.required", "patronCategoryId", "domain.circulationMatrix.patronCategoryId");
        }
        else {
            command.setPatronCategoryId(Integer.valueOf(dto.getPatronCategoryId()));
        }

        if(Strings.isNullOrEmpty(dto.getMaterialTypeId())) {
            processError.addError("common.field.required", "materialTypeId", "domain.circulationMatrix.materialTypeId");
        }
        else {
            command.setMaterialTypeId(Integer.valueOf(dto.getMaterialTypeId()));
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getWithEffectFrom())) {
            processError.addError("common.field.pattern", "withEffectFrom", "domain.circulationMatrix.withEffectFrom", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        }
        else {
            command.setWithEffectFrom(DateHelper.fromDateString(dto.getWithEffectFrom()));
        }

        return command;
    }
}
