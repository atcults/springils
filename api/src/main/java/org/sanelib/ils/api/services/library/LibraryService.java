package org.sanelib.ils.api.services.library;

import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.PUBLISHER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryService extends ApiServiceBase {

    @GET
    public List getAllLibraries() throws Throwable {
        List<LibraryDto> list = new ArrayList<>();
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setId("1");
        libraryDto.setName("Library Name 1");
        libraryDto.setCity("City");
        libraryDto.setState("State");
        libraryDto.setCountry("Country");
        list.add(libraryDto);
        return list;
    }

    @POST
    public String addLibrary(LibraryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_LIBRARY);
    }

    @PUT
    public String updatePublisher(LibraryDto dto) throws Throwable {
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
