package org.sanelib.ils.api.converters.author;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.springframework.stereotype.Component;

@Component
public class AuthorViewConverter extends AbstractViewToDtoConverterImpl<AuthorDto, AuthorView> {

    @Override
    public AuthorDto convert(AuthorView authorView) {

        AuthorDto authorDto = new AuthorDto();

        authorDto.setCode(authorView.getCode());
        authorDto.setLastName(authorView.getLastName());
        authorDto.setFirstName(authorView.getFirstName());
        authorDto.setPhone(authorView.getPhone());
        authorDto.setAddress(authorView.getAddress());
        authorDto.setCity(authorView.getCity());
        authorDto.setState(authorView.getState());
        authorDto.setZipCode(authorView.getZipCode());
        authorDto.setContract(String.valueOf(authorView.isContract()));

        return authorDto;
    }
}
