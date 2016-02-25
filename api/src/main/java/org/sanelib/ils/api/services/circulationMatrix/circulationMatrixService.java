package org.sanelib.ils.api.services.circulationMatrix;

import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.enums.DurationType;
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
@Path(ApiEndPointConstants.Admin.CIRCULATION_MATRIX_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class circulationMatrixService extends ApiServiceBase {

    @GET
    public List getAllCirculationMatrix() throws Throwable {

        List<CirculationMatrixDto> list = new ArrayList<>();

        CirculationMatrixDto circulationMatrixDto = new CirculationMatrixDto();

        circulationMatrixDto.setPatronCategoryId("1");
        circulationMatrixDto.setMaterialTypeId("1");
        circulationMatrixDto.setWithEffectFrom("2016-02-02");
        circulationMatrixDto.setRenewalThroughOPAC(true);
        circulationMatrixDto.setLoanDurationType(DurationType.Days);
        circulationMatrixDto.setLoanDuration("1");
        circulationMatrixDto.setLoanDurationType(DurationType.Fixed);
        circulationMatrixDto.addFixedDateDue("2", "2");
        circulationMatrixDto.setOverAllLoanLimit("2");
        circulationMatrixDto.setRenewalLimit("2");
        circulationMatrixDto.setFinePerDay("2");
        circulationMatrixDto.setMaxFine("2");
        circulationMatrixDto.setIncludeHolidaysInDateDue(true);
        circulationMatrixDto.setChargeDurationType(DurationType.Hours);
        circulationMatrixDto.addChargeDetail("2", "2", "2.2");
        circulationMatrixDto.setIncludeHolidaysInCharges(true);

        list.add(circulationMatrixDto);
        return list;

    }

    @POST
    public String addCirculationMatrix(CirculationMatrixDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_CIRCULATION_MATRIX);
    }

    @PUT
    public String updateCirculationMatrix(CirculationMatrixDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_CIRCULATION_MATRIX);
    }

    @DELETE
    @Path("/{libraryId}/{patronCategoryId}/{patronCategoryLibraryId}/{materialTypeId}/{withEffectFrom}")
    public String deleteCirculationMatrix(@PathParam("libraryId") String libraryId, @PathParam("patronCategoryId") String patronCategoryId, @PathParam("patronCategoryLibraryId") String patronCategoryLibraryId, @PathParam("materialTypeId") String materialTypeId, @PathParam("withEffectFrom") String withEffectFrom) throws Throwable {

        CirculationMatrixDto circulationMatrixDto = new CirculationMatrixDto();

        circulationMatrixDto.setLibraryId(libraryId);
        circulationMatrixDto.setPatronCategoryId(patronCategoryId);
        circulationMatrixDto.setMaterialTypeId(materialTypeId);
        circulationMatrixDto.setWithEffectFrom(withEffectFrom);

        return execute(circulationMatrixDto, ActivitiProcessConstants.Admin.DELETE_CIRCULATION_MATRIX);
    }
}
