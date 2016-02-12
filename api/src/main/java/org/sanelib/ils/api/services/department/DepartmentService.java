package org.sanelib.ils.api.services.department;

import org.sanelib.ils.api.dto.department.DepartmentDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.ViewNameConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.DEPARTMENT_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentService extends ApiServiceBase {

    @GET
    public List getAllDepartments() throws Throwable {
        return fetchAll(ViewNameConstants.Admin.DEPARTMENT);
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
