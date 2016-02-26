package org.sanelib.ils.api.converters.author;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.author.AuthorDto;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.springframework.stereotype.Component;

@Component
public class AuthorViewConverter extends AbstractViewToDtoConverterImpl<AuthorDto, AuthorView> {

    @Override
    public AuthorDto convert(AuthorView authorView) {

        AuthorDto authorDTO = new AuthorDto();

        authorDTO.setCode(authorView.getCode());
        authorDTO.setLastName(authorView.getLastName());
        authorDTO.setFirstName(authorView.getFirstName());
        authorDTO.setPhone(authorView.getPhone());
        authorDTO.setAddress(authorView.getAddress());
        authorDTO.setCity(authorView.getCity());
        authorDTO.setState(authorView.getState());
        authorDTO.setZipCode(authorView.getZipCode());
        authorDTO.setContract(String.valueOf(authorView.isContract()));

        return authorDTO;
    }
}
