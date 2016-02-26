package org.sanelib.ils.api.services.publisher;

import org.sanelib.ils.api.dto.publisher.PublisherDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
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
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.PUBLISHER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class PublisherService extends ApiServiceBase {

    @GET
    public List getAllPublishers() throws Throwable {
        List<PublisherDto> list = new ArrayList<>();
        PublisherDto pub1 = new PublisherDto();
        pub1.setCode("1");
        pub1.setName("Publisher Name 1");
        pub1.setCity("City");
        pub1.setState("State");
        pub1.setCountry("Country");
        list.add(pub1);
        return list;
    }

    @POST
    public String addPublisher(PublisherDto publisherDto) throws Throwable {
        return execute(publisherDto, ActivitiProcessConstants.Admin.ADD_PUBLISHER);
    }

    @PUT
    public String updatePublisher(PublisherDto publisherDTO) throws Throwable {
        return execute(publisherDTO, ActivitiProcessConstants.Admin.UPDATE_PUBLISHER);
    }

    @DELETE
    @Path("/{id}")
    public String deletePublisher(@PathParam("id") String id) throws Throwable {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setCode(id);
        return execute(publisherDto, ActivitiProcessConstants.Admin.DELETE_PUBLISHER);
    }
}
