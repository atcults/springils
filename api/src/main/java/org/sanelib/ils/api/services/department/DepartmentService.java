package org.sanelib.ils.api.services.department;

import org.sanelib.ils.api.converters.department.DepartmentViewConverter;
import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.DepartmentViewRepository;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
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
@Path(ApiEndPointConstants.Admin.DEPARTMENT_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentService extends ApiServiceBase {

    @Autowired
    DepartmentViewRepository departmentViewRepository;

    @Autowired
    DepartmentViewConverter departmentViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllPatronCategories() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = departmentViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> departmentViewConverter.convert((DepartmentView) v)).collect(Collectors.toList()));
        return dtoList;
    }

    @POST
    public String addDepartment(DepartmentDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_DEPARTMENT);
    }

    @PUT
    public String updateDepartment(DepartmentDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_DEPARTMENT);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteDepartment(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setLibraryId(libraryId);
        departmentDto.setId(id);
        return execute(departmentDto, ActivitiProcessConstants.Admin.DELETE_DEPARTMENT);
    }
}
