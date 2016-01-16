package org.sanelib.ils.api.converters.library;

import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateLibraryConverter extends AddLibraryConverter {

    @Override
    public ProcessCommand convert(LibraryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddLibrary addLibrary = (AddLibrary) super.convert(dto, processError);

        UpdateLibrary updateLibrary = new UpdateLibrary();
        ReflectionHelper.copy(addLibrary, updateLibrary);

        return updateLibrary;
    }
}
