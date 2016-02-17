package org.sanelib.ils.api.services.patronCategory;

import org.sanelib.ils.api.converters.patronCategory.PatronCategoryViewConverter;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.PatronCategoryViewRepository;
import org.sanelib.ils.core.domain.view.admin.PatronCategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.PATRON_CATEGORY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class PatronCategoryService extends ApiServiceBase {

    @Autowired
    PatronCategoryViewRepository patronCategoryViewRepository;

    @Autowired
    PatronCategoryViewConverter patronCategoryViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllPatronCategories() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = patronCategoryViewRepository.getAll();
        dtoList.addAll((Collection) viewList.stream().map(v -> patronCategoryViewConverter.convert((PatronCategoryView) v)).collect(Collectors.toList()));
        return dtoList;
    }

    @POST
    public String addPatronCategory(PatronCategoryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_PATRON_CATEGORY);
    }

    @PUT
    public String updatePatronCategory(PatronCategoryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_PATRON_CATEGORY);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deletePatronCategory(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        PatronCategoryDto patronCategoryDto = new PatronCategoryDto();
        patronCategoryDto.setLibraryId(libraryId);
        patronCategoryDto.setId(id);
        return execute(patronCategoryDto, ActivitiProcessConstants.Admin.DELETE_PATRON_CATEGORY);
    }
}
