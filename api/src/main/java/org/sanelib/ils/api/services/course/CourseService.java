package org.sanelib.ils.api.services.course;

import org.sanelib.ils.api.dto.agency.AgencyDto;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.ViewNameConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.COURSE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class CourseService extends ApiServiceBase {

    @GET
    public List getAllCourses() throws Throwable{
        return fetchAll(ViewNameConstants.Admin.COURSE);
    }

    @POST
    public String addCourse(CourseDto dto) throws Throwable{

        return execute(dto, ActivitiProcessConstants.Admin.ADD_COURSE);
    }

    @PUT
    public  String updateCourse(CourseDto dto) throws Throwable{
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_COURSE);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public  String deleteCourse(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable{
        CourseDto courseDto=new CourseDto();
        courseDto.setLibraryId(libraryId);
        courseDto.setId(id);
        return execute(courseDto, ActivitiProcessConstants.Admin.DELETE_COURSE);
    }
}
