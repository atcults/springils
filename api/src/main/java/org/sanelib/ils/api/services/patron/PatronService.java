package org.sanelib.ils.api.services.patron;


import org.sanelib.ils.api.dto.patron.PatronDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.enums.PatronType;
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
@Path(ApiEndPointConstants.Admin.PATRON_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class PatronService extends ApiServiceBase{

    @GET
    public List getAllPatron() throws Throwable {
        List<PatronDto> list = new ArrayList<>();

        PatronDto patronDto = new PatronDto();

        patronDto.setLibraryId("1");
        patronDto.setCode("Pat1");
        patronDto.setPatronCategoryId("1");
        patronDto.setIsOnline("Is Online");
        patronDto.setOwns("Owns");
        patronDto.setCreatedOn("2014/05/02");
        patronDto.setOtherLibraryPatronId("1");
        patronDto.setLibraryPatronId("1");
        patronDto.setPatronType(PatronType.Patron);
        patronDto.setDeptId("1");
        patronDto.setFirstName("First Name");
        patronDto.setAddress1("Address1");
        patronDto.setAddress2("Address2");
        patronDto.setCity("City");
        patronDto.setState("State");
        patronDto.setCountry("Country");
        patronDto.setPin("387003");
        patronDto.setPhone1("+91-9876543210");
        patronDto.setPhone2("+91-9876543210");
        patronDto.setFax("+91-9876543210");
        patronDto.setEmail("name@mail.com");
        patronDto.setPermanentAddress1("PAddress1");
        patronDto.setPermanentAddress2("PAddress2");
        patronDto.setPermanentCity("PCity");
        patronDto.setPermanentState("PState");
        patronDto.setPermanentCountry("PCountry");
        patronDto.setPermanentPin("PPin");
        patronDto.setPermanentPhone1("+91-9876543210");
        patronDto.setPermanentPhone2("+91-9876543210");
        patronDto.setPermanentFax("+91-9876543210");
        patronDto.setPermanentEmail("name@mail.com");
        patronDto.setMembershipFrom("2014/04/01");
        patronDto.setMembershipTo("2016/03/31");
        patronDto.setDelinquencyReason("Reason");
        patronDto.setCommonEmail("A");
        patronDto.setCommonInstantMsg("B");
        patronDto.setCommonPrint("A");
        patronDto.setEntryDate("2013/02/01");
        patronDto.setUserPassword("password");
        patronDto.setCourseId("1");
        patronDto.setCustom("Custom");
        patronDto.setPrivilege("privilege");
        patronDto.setTwitterId("TId");
        patronDto.setFacebookId("FId");
        patronDto.setSubLocationId("1");
        patronDto.setLoginId("LId");
        patronDto.setAuthenticateLocalDatabase("A");

        list.add(patronDto);
        return list;
    }

    @POST
    public String addPatron(PatronDto dto) throws Throwable{
        return execute(dto, ActivitiProcessConstants.Admin.ADD_PATRON);
    }

    @PUT
    public String updatePatron(PatronDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_PATRON);
    }

    @DELETE
    @Path("/{libraryId}/{code}")
    public String deletePatron(@PathParam("libraryId") String libraryId, @PathParam("code") String code) throws Throwable {

        PatronDto patronDto = new PatronDto();
        patronDto.setCode(code);
        patronDto.setLibraryId(libraryId);

        return execute(patronDto, ActivitiProcessConstants.Admin.DELETE_PATRON);
    }
}
