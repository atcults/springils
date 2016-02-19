package org.sanelib.ils.api.services.accessionSeries;

import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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
        accessionSeriesDto.setEntryId("1");
        accessionSeriesDto.setEntryDate("2016-01-01");

        list.add(accessionSeriesDto);
        return list;
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
