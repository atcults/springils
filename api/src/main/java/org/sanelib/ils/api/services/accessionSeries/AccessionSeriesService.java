package org.sanelib.ils.api.services.accessionSeries;

import org.sanelib.ils.api.converters.accessionSeries.AccessionSeriesViewConverter;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.AccessionSeriesViewRepository;
import org.sanelib.ils.core.domain.view.admin.AccessionSeriesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.ACCESSION_SERIES_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class AccessionSeriesService extends ApiServiceBase {

    @Autowired
    AccessionSeriesViewRepository accessionSeriesViewRepository;

    @Autowired
    AccessionSeriesViewConverter accessionSeriesViewConverter;


    @GET
    @SuppressWarnings("unchecked")
    public List getAllAccessionSeries() throws Throwable {

        List dtoList = new ArrayList<>();
        List viewList = accessionSeriesViewRepository.getAll();

        dtoList.addAll((Collection) viewList.stream().map(v -> accessionSeriesViewConverter.convert(
                (AccessionSeriesView) v)).collect(Collectors.toList()));

        return dtoList;
    }

    @POST
    public String addAccessionSeries(AccessionSeriesDto dto) throws Throwable{
        return execute(dto, ActivitiProcessConstants.Admin.ADD_ACCESSIONSERIES);
    }

    @PUT
    public String updateAccessionSeries(AccessionSeriesDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_ACCESSIONSERIES);
    }

    @DELETE
    @Path("/{libraryId}/{code}")
    public String deleteAgency(@PathParam("libraryId") String libraryId, @PathParam("code") String code) throws Throwable {

        AccessionSeriesDto accessionSeriesDto = new AccessionSeriesDto();
        accessionSeriesDto.setCode(code);
        accessionSeriesDto.setLibraryId(libraryId);

        return execute(accessionSeriesDto, ActivitiProcessConstants.Admin.DELETE_ACCESSIONSERIES);
    }
}
