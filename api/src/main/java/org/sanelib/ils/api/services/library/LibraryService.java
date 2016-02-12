package org.sanelib.ils.api.services.library;

import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.ViewNameConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.LIBRARY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryService extends ApiServiceBase {

    @GET
    public List getAllLibraries() throws Throwable {
        return fetchAll(ViewNameConstants.Admin.LIBRARY);
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
