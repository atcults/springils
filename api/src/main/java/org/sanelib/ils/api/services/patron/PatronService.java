package org.sanelib.ils.api.services.patron;

import org.sanelib.ils.api.converters.patron.PatronViewConverter;
import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.PatronViewRepository;
import org.sanelib.ils.core.domain.view.admin.PatronView;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.PATRON_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class PatronService extends ApiServiceBase{

    @Autowired
    PatronViewRepository patronViewRepository;

    @Autowired
    PatronViewConverter patronViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllPatron() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = patronViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> patronViewConverter.convert((PatronView) v)).collect(Collectors.toList()));
        return dtoList;
    }

    @POST
    public String addPatron(PatronDto dto) throws Throwable{
        return execute(dto, ActivitiProcessConstants.Admin.ADD_PATRON);
    }

    @PUT
    public String updatePatron(PatronDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_PATRON);
    }

    @DELETE
    @Path("/{libraryId}/{code}")
    public String deletePatron(@PathParam("libraryId") String libraryId, @PathParam("code") String code) throws Throwable {

        PatronDto patronDto = new PatronDto();
        patronDto.setCode(code);
        patronDto.setLibraryId(libraryId);

        return execute(patronDto, ActivitiProcessConstants.Admin.DELETE_PATRON);
    }
}
