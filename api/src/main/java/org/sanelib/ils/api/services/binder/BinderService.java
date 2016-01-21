package org.sanelib.ils.api.services.binder;

import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.BINDER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class BinderService extends ApiServiceBase {

    @GET
    public List getAllBinders() throws Throwable {
        List<BinderDto> list = new ArrayList<>();

        BinderDto binderDto = new BinderDto();

        binderDto.setId("1");
        binderDto.setLibraryId("1");
        binderDto.setBinderName("Test Binder");
        binderDto.setPrimaryAddress("Primary Address");
        binderDto.setSecondaryAddress("Secondary Address");
        binderDto.setCity("TestCity");
        binderDto.setState("TestState");
        binderDto.setCountry("TestCountry");
        binderDto.setPin("654321");
        binderDto.setPrimaryPhoneNumber("+91-987654321");
        binderDto.setSecondaryPhoneNumber("+91-879654321");
        binderDto.setFax("87654321");
        binderDto.setEmail("user@emailprovider.com");
        binderDto.setEntryId("user");
        binderDto.setEntryDate("2015/04/01");
        list.add(binderDto);

        return list;
    }

    @POST
    public String addBinder(BinderDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_BINDER);
    }

    @PUT
    public String updateBinder(BinderDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_BINDER);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteBinder(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        BinderDto binderDto = new BinderDto();

        binderDto.setLibraryId(libraryId);
        binderDto.setId(id);

        return execute(binderDto, ActivitiProcessConstants.Admin.DELETE_BINDER);
    }
}
