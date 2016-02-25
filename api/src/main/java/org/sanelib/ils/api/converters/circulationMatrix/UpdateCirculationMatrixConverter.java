package org.sanelib.ils.api.converters.circulationMatrix;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.commands.circulationMatrix.UpdateCirculationMatrix;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateCirculationMatrixConverter extends AddCirculationMatrixConverter {

    @Override
    public ProcessCommand convert(CirculationMatrixDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddCirculationMatrix addCirculationMatrix = (AddCirculationMatrix) super.convert(dto, processError);
        UpdateCirculationMatrix updateCirculationMatrix = new UpdateCirculationMatrix();
        ReflectionHelper.copy(addCirculationMatrix, updateCirculationMatrix);
        ConverterHelper.checkLibraryIdRequired(dto, updateCirculationMatrix, processError);
        return updateCirculationMatrix;
    }
}
