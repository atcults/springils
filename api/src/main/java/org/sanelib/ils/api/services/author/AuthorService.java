package org.sanelib.ils.api.services.author;

import org.sanelib.ils.api.dto.author.AuthorDTO;
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
@Path(ApiEndPointConstants.Admin.AUTHOR_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorService extends ApiServiceBase {

    @GET
    public List getAllAuthors() throws Throwable {
        List<AuthorDTO> list = new ArrayList<>();

        AuthorDTO author = new AuthorDTO();

        author.setCode("1");
        author.setLastName("Author Last Name");
        author.setFirstName("Author First Name");
        author.setPhone("+91-9876543219");
        author.setAddress("Address");
        author.setCity("city");
        author.setState("ST");
        author.setZipCode("54321");
        author.setContract("false");

        list.add(author);

        return list;
    }

    @POST
    public String addAuthor(AuthorDTO authorDTO) throws Throwable {
        return execute(authorDTO, ActivitiProcessConstants.Admin.ADD_AUTHOR);
    }

    @PUT
    public String updateAuthor(AuthorDTO authorDTO) throws Throwable {
        return execute(authorDTO, ActivitiProcessConstants.Admin.UPDATE_AUTHOR);
    }

    @DELETE
    @Path("/{id}")
    public String deleteAuthor(@PathParam("id") String code) throws Throwable {
        AuthorDTO authorDto = new AuthorDTO();

        authorDto.setCode(code);

        return execute(authorDto, ActivitiProcessConstants.Admin.DELETE_AUTHOR);
    }
}
