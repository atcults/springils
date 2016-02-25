package org.sanelib.ils.api.services.accessionSeries;

import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.enums.AccessionSeriesType;
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
@Path(ApiEndPointConstants.Admin.ACCESSION_SERIES_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class AccessionSeriesService extends ApiServiceBase {

    @GET
    public List getAllAccessionSeries() throws Throwable {
        List<AccessionSeriesDto> list = new ArrayList<>();

        AccessionSeriesDto accessionSeriesDto = new AccessionSeriesDto();

        accessionSeriesDto.setCode("AS1");
        accessionSeriesDto.setLibraryId("1");
        accessionSeriesDto.setMaxNumber("100");
        accessionSeriesDto.setMaxZero("2");
        accessionSeriesDto.setPrefix("AS");
        accessionSeriesDto.setTypeName(AccessionSeriesType.Fixed);

        list.add(accessionSeriesDto);
        return list;
    }

    @POST
    public String addAccessionSeries(AccessionSeriesDto dto) throws Throwable{
        return execute(dto, ActivitiProcessConstants.Admin.ADD_ACCESSION_SERIES);
    }

    @PUT
    public String updateAccessionSeries(AccessionSeriesDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_ACCESSION_SERIES);
    }

    @DELETE
    @Path("/{libraryId}/{code}")
    public String deleteAgency(@PathParam("libraryId") String libraryId, @PathParam("code") String code) throws Throwable {

        AccessionSeriesDto accessionSeriesDto = new AccessionSeriesDto();
        accessionSeriesDto.setCode(code);
        accessionSeriesDto.setLibraryId(libraryId);

        return execute(accessionSeriesDto, ActivitiProcessConstants.Admin.DELETE_ACCESSION_SERIES);
    }
}
