package org.sanelib.ils.api.services.library;

import org.sanelib.ils.api.converters.library.LibraryViewConverter;
import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.LibraryViewRepository;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.LIBRARY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryService extends ApiServiceBase {

    @Autowired
    LibraryViewRepository libraryViewRepository;

    @Autowired
    LibraryViewConverter libraryViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllLibraries() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = libraryViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> libraryViewConverter.convert((LibraryView) v)).collect(Collectors.toList()));
        return dtoList;
    }

    @POST
    public String addLibrary(LibraryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_LIBRARY);
    }

    @PUT
    public String updateLibrary(LibraryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_LIBRARY);
    }

    @DELETE
    @Path("/{id}")
    public String deleteLibrary(@PathParam("id") String id) throws Throwable {
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setId(id);
        return execute(libraryDto, ActivitiProcessConstants.Admin.DELETE_LIBRARY);
    }
}
