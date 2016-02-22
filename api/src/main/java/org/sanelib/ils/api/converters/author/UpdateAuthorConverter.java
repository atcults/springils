package org.sanelib.ils.api.converters.author;

import org.sanelib.ils.api.dto.author.AuthorDTO;
import org.sanelib.ils.common.utils.ReflectionHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.commands.author.UpdateAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateAuthorConverter extends AddAuthorConverter {

    @Override
    public ProcessCommand convert(AuthorDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddAuthor addAuthor = (AddAuthor) super.convert(dto, processError);

        UpdateAuthor updateAuthor = new UpdateAuthor();
        ReflectionHelper.copy(addAuthor, updateAuthor);

        return updateAuthor;
    }
}
