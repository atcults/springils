package org.sanelib.ils.api.services.materialType;

import org.sanelib.ils.api.converters.materialType.MaterialTypeViewConverter;
import org.sanelib.ils.api.dto.materialType.MaterialTypeDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.MaterialTypeViewRepository;
import org.sanelib.ils.core.domain.view.admin.MaterialTypeView;
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
@Path(ApiEndPointConstants.Admin.MATERIAL_TYPE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class MaterialTypeService extends ApiServiceBase {

    @Autowired
    MaterialTypeViewRepository materialTypeViewRepository;

    @Autowired
    MaterialTypeViewConverter materialTypeViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllMaterialTypes() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = materialTypeViewRepository.getAllMaterialTypes();

        dtoList.addAll((Collection) viewList.stream().map(v -> materialTypeViewConverter.convert((MaterialTypeView) v)).collect(Collectors.toList()));

        return dtoList;
    }

    @POST
    public String addMaterialType(MaterialTypeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_MATERIAL_TYPE);
    }

    @PUT
    public String updateMaterialType(MaterialTypeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_MATERIAL_TYPE);
    }

    @DELETE
    @Path("/{id}")
    public String deleteMaterialType(@PathParam("id") String id) throws Throwable {
        MaterialTypeDto materialTypeDto = new MaterialTypeDto();

        materialTypeDto.setId(id);

        return execute(materialTypeDto, ActivitiProcessConstants.Admin.DELETE_MATERIAL_TYPE);
    }
}
