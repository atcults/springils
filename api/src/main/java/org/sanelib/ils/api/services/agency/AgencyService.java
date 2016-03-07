package org.sanelib.ils.api.services.agency;

import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.AGENCY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class AgencyService extends ApiServiceBase {

    @GET
    public List getAllAgencies() throws Throwable {
        List<AgencyDto> list = new ArrayList<>();
        AgencyDto agencyDto = new AgencyDto();
        agencyDto.setId("1");
        agencyDto.setLibraryId("1");
        agencyDto.setName("Agency Name 1");
        list.add(agencyDto);
        return list;
    }

    @POST
    public String addAgency(AgencyDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_AGENCY);
    }

    @PUT
    public String updateAgency(AgencyDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_AGENCY);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteAgency(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        AgencyDto agencyDto = new AgencyDto();
        agencyDto.setLibraryId(libraryId);
        agencyDto.setId(id);
        return execute(agencyDto, ActivitiProcessConstants.Admin.DELETE_AGENCY);
    }
}
