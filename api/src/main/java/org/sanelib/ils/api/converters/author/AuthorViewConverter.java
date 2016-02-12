package org.sanelib.ils.api.converters.author;

import org.sanelib.ils.api.converters.ViewToDtoConverter;
import org.sanelib.ils.api.dto.author.AuthorDTO;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.springframework.stereotype.Component;

@Component
public class AuthorViewConverter implements ViewToDtoConverter<AuthorDTO , AuthorView> {
    @Override
    public AuthorDTO convert(AuthorView authorView) {

        AuthorDTO authorDTO = new AuthorDTO();

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
