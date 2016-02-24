package org.sanelib.ils.api.services.bindingType;

import org.sanelib.ils.api.converters.bindingType.BindingTypeViewConverter;
import org.sanelib.ils.api.dto.bindingType.BindingTypeDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.BindingTypeViewRepository;
import org.sanelib.ils.core.domain.view.admin.BindingTypeView;
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
@Path(ApiEndPointConstants.Admin.BINDING_TYPE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class BindingTypeService extends ApiServiceBase {

    @Autowired
    BindingTypeViewRepository bindingTypeViewRepository;

    @Autowired
    BindingTypeViewConverter bindingTypeViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllBindingTypes() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = bindingTypeViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> bindingTypeViewConverter.convert((BindingTypeView) v)).collect(Collectors.toList()));
        return dtoList;
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
