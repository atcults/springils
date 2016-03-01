package org.sanelib.ils.api.services.binder;

import org.sanelib.ils.api.converters.binder.BinderViewConverter;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.BinderViewRepository;
import org.sanelib.ils.core.domain.view.admin.BinderView;
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
@Path(ApiEndPointConstants.Admin.BINDER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class BinderService extends ApiServiceBase {

    @Autowired
    BinderViewRepository binderViewRepository;

    @Autowired
    BinderViewConverter binderViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllBinders() throws Throwable {

        List dtoList = new ArrayList<>();
        List viewList = binderViewRepository.getAllBinders();

        dtoList.addAll((Collection) viewList.stream().map(v -> binderViewConverter.convert((BinderView) v)).collect(Collectors.toList()));

        return dtoList;
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
        BinderDto dto = new BinderDto();

        dto.setLibraryId(libraryId);
        dto.setId(id);

        return execute(dto, ActivitiProcessConstants.Admin.DELETE_BINDER);
    }
}
