package org.sanelib.ils.api.services.holiday;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.holiday.HolidayViewConverter;
import org.sanelib.ils.api.dto.holiday.HolidayDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.HolidayViewRepository;
import org.sanelib.ils.core.domain.view.admin.HolidayView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.HOLIDAY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class HolidayService extends ApiServiceBase {

    @Autowired
    HolidayViewRepository holidayViewRepository;

    @Autowired
    HolidayViewConverter holidaysViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    @Path("/{libraryId}/{fiscalYearId}")
    public List<HolidayDto> getAllHolidays(@PathParam("libraryId") String libraryId,
                                           @PathParam("fiscalYearId") String fiscalYearId) throws Exception{

        Integer lid = null;
        if(RegularExpressionHelper.checkIdFormat(libraryId)){
            lid = Integer.parseInt(libraryId);
        }

        Integer fid = null;
        if(RegularExpressionHelper.checkIdFormat(fiscalYearId)){
            fid = Integer.parseInt(fiscalYearId);
        }

        if(lid == null || fid == null) {
            return new ArrayList<>();
        }

        List viewList = holidayViewRepository.getHolidaysForFiscalYear(Integer.parseInt(libraryId), Integer.parseInt(fiscalYearId));
        return holidaysViewConverter.convert(viewList);
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
        return execute(dto, ActivitiProcessConstants.Admin.DELETE_HOLIDAY);
    }
}
