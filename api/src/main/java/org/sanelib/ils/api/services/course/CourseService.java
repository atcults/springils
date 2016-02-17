package org.sanelib.ils.api.services.course;

import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.ViewNameConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
