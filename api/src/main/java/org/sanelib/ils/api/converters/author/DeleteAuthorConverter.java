package org.sanelib.ils.api.converters.author;

import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.author.DeleteAuthor;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteAuthorConverter implements DtoToCommandConverter<AuthorDto> {
    public ProcessCommand convert(AuthorDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteAuthor command = new DeleteAuthor();

        ConverterHelper.checkCodeRequired(dto, command, processError);

       return command;
    }
}
