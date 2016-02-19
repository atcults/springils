package org.sanelib.ils.api.services.fiscalYear;

import org.sanelib.ils.api.dto.fiscalYear.FiscalYearDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.FISCAL_YEAR_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class FiscalYearService extends ApiServiceBase {

    @GET
    public List<FiscalYearDto> getAllFiscalYearDTOs() throws Exception {

        List<FiscalYearDto> dtos = new ArrayList<>();

        FiscalYearDto fiscalYearDTO = new FiscalYearDto();

        fiscalYearDTO.setLibraryId("101");
        fiscalYearDTO.setId("12345");
        fiscalYearDTO.setStartDate("2015-04-01");
        fiscalYearDTO.setEndDate("2016-03-31");

        dtos.add(fiscalYearDTO);

        return dtos;
    }

    @POST
    public String addFiscalYear(FiscalYearDto fiscalYearDTO) throws Throwable {
        return execute(fiscalYearDTO, ActivitiProcessConstants.Admin.ADD_FISCAL_YEAR);
    }

    @PUT
    public String updateFiscalYear(FiscalYearDto fiscalYearDTO) throws Throwable {
        return execute(fiscalYearDTO, ActivitiProcessConstants.Admin.UPDATE_FISCAL_YEAR);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteFiscalYear(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        FiscalYearDto fiscalYearDto = new FiscalYearDto();

        fiscalYearDto.setLibraryId(libraryId);
        fiscalYearDto.setId(id);

        return execute(fiscalYearDto, ActivitiProcessConstants.Admin.DELETE_FISCAL_YEAR);
    }
}
