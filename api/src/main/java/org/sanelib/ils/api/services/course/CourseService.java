package org.sanelib.ils.api.services.course;

import org.sanelib.ils.api.converters.course.CourseViewConverter;
import org.sanelib.ils.api.dto.course.CourseDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.CourseViewRepository;
import org.sanelib.ils.core.domain.view.admin.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.COURSE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class CourseService extends ApiServiceBase {

    @Autowired
    CourseViewRepository courseViewRepository;

    @Autowired
    CourseViewConverter courseViewConverter;


    @GET
    @SuppressWarnings("unchecked")
    public List getAllCourses() throws Throwable{
        List dtoList = new ArrayList<>();
        List viewList = courseViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> courseViewConverter.convert((CourseView) v)).collect(Collectors.toList()));
        return dtoList;
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
