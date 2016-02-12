package org.sanelib.ils.api.services.holiday;

import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        holidayDto.setHolidayType("Specific");
        holidayDto.setNote(null);

        dtos.add(holidayDto);

        return dtos;
    }

    @POST
    public String addHoliday(HolidayDto holidayDto) throws Throwable {
        return execute(holidayDto, ActivitiProcessConstants.Admin.ADD_HOLIDAY);
    }
}
