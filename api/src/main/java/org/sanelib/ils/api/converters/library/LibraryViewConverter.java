package org.sanelib.ils.api.converters.library;

import org.sanelib.ils.api.converters.AbstractViewToDtoConverterImpl;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

@Component
public class LibraryViewConverter extends AbstractViewToDtoConverterImpl<LibraryDto, LibraryView> {

    @Override
    public LibraryDto convert(LibraryView libraryView) {
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setId(String.valueOf(libraryView.getId()));
        libraryDto.setName(libraryView.getName());
        libraryDto.setCity(libraryView.getCity());
        libraryDto.setState(libraryView.getState());
        libraryDto.setCountry(libraryView.getCountry());
        return libraryDto;
    }
}