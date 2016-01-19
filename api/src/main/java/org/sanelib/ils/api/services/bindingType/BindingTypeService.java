package org.sanelib.ils.api.services.bindingType;

import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.BINDING_TYPE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class BindingTypeService extends ApiServiceBase {

    @GET
    public List getAllBindngType() throws Throwable {
        List<BindingTypeDto> list = new ArrayList<>();
        BindingTypeDto bindingTypeDto = new BindingTypeDto();
        bindingTypeDto.setId("1");
        bindingTypeDto.setLibraryId("1");
        bindingTypeDto.setBindType("BindType");
        bindingTypeDto.setPrice("500");
        bindingTypeDto.setEntryId("EntryId01");
        bindingTypeDto.setEntryDate("2007/01/02");
        list.add(bindingTypeDto);
        return list;
    }

    @POST
    public String addBindingType(BindingTypeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_BINDING_TYPE);
    }

    @PUT
    public String updateBindingType(BindingTypeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_BINDING_TYPE);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteBindingType(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        BindingTypeDto bindingTypeDto = new BindingTypeDto();
        bindingTypeDto.setLibraryId(libraryId);
        bindingTypeDto.setId(id);
        return execute(bindingTypeDto, ActivitiProcessConstants.Admin.DELETE_BINDING_TYPE);
    }
}
