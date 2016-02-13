package org.sanelib.ils.api.services.holiday;

import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.HOLIDAY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class HolidayService extends ApiServiceBase {

    @GET
    public List<HolidayDto> getAllHolidayDtos() throws Exception{

        List<HolidayDto> dtos = new ArrayList<>();

        HolidayDto holidayDto = new HolidayDto();

        holidayDto.setLibraryId("1");
        holidayDto.setFiscalYearId("20152016");
        holidayDto.setStartDate("2016/02/09");
        holidayDto.setEndDate("2016/02/29");
        holidayDto.setHolidayTypeName("Specific");
        holidayDto.setNote("note");

        dtos.add(holidayDto);

        return dtos;
    }

    @POST
    public String addHoliday(HolidayDto holidayDto) throws Throwable {
        return execute(holidayDto, ActivitiProcessConstants.Admin.ADD_HOLIDAY);
    }

    @DELETE
    @Path("/{libraryId}/{fiscalYearId}/{holidayType}/{startDate}/{endDate}")
    public String deleteHoliday(@PathParam("libraryId") String libraryId,
                                @PathParam("fiscalYearId") String fiscalYearId,
                                @PathParam("holidayType") String holidayType,
                                @PathParam("startDate") String startDate,
                                @PathParam("endDate") String endDate) throws Throwable {
        HolidayDto dto = new HolidayDto();
        dto.setLibraryId(libraryId);
        dto.setFiscalYearId(fiscalYearId);
        dto.setHolidayTypeName(holidayType);
        dto.setStartDate(startDate);
        dto.setEndDate(endDate);
        return execute(dto, ActivitiProcessConstants.Admin.DELETE_LIBRARY);
    }
}
