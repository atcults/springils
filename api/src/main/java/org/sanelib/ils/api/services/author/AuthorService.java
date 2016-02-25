package org.sanelib.ils.api.services.author;

import org.sanelib.ils.api.converters.author.AuthorViewConverter;
import org.sanelib.ils.api.dto.author.AuthorDTO;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.AuthorViewRepository;
import org.sanelib.ils.core.domain.view.admin.AuthorView;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
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
@Path(ApiEndPointConstants.Admin.AUTHOR_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorService extends ApiServiceBase {

    @Autowired
    AuthorViewRepository authorViewRepository;

    @Autowired
    AuthorViewConverter authorViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllAuthors() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = authorViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> authorViewConverter.convert((AuthorView) v)).collect(Collectors.toList()));
        return dtoList;
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
