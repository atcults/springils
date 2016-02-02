package org.sanelib.ils.api.services.library;

import org.sanelib.ils.api.dto.library.LibraryDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
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
@Path(ApiEndPointConstants.Admin.LIBRARY_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryService extends ApiServiceBase {

    @GET
    public List getAllLibraries() throws Throwable {
        List<LibraryDto> list = new ArrayList<>();
        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId("1");
        libraryDto.setName("name");
        libraryDto.setSerialMaster("SerialMaster");
        libraryDto.setCatalogueMaster("CatalogueMaster");
        libraryDto.setAcquisitionsMaster("AcquisitionMaster");
        libraryDto.setCreatedOn("2015/12/12");
        libraryDto.setAcquisitionStatus("AcqStatus");
        libraryDto.setCataloguingStatus("CatStatus");
        libraryDto.setSmStatus("SmStatus");
        libraryDto.setHostLibraryId("100");
        libraryDto.setFirstAddress("FirstAddress");
        libraryDto.setSecondAddress("SecondAddress");
        libraryDto.setCity("city");
        libraryDto.setState("ST");
        libraryDto.setPin("54321");
        libraryDto.setFirstPhoneNumber("+91-9876543210");
        libraryDto.setEmail("user@emailprovider.com");
        libraryDto.setSecondPhoneNumber("+91-8976543210");
        libraryDto.setFax("+91-9876543210");
        libraryDto.setCountry("country");
        libraryDto.setNetworkName("Network Name");
        libraryDto.setSearchForms("Search Forms");
        libraryDto.setFacebookWidget("Facebook Widget");
        libraryDto.setTwitterWidget("Twitter Widget");
        libraryDto.setAboutLibrary("About Library");
        libraryDto.setAboutOrganization("About Organization");
        libraryDto.setLibraryTimings("Library Timings");
        libraryDto.setContactUs("Contact Us");
        libraryDto.setMapWidget("Map Widget");
        libraryDto.setDescription("Description");
        libraryDto.setWebStatistics("Web Statistics");

        list.add(libraryDto);
        return list;
    }

    @POST
    public String addLibrary(LibraryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_LIBRARY);
    }

    @PUT
    public String updateLibrary(LibraryDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_LIBRARY);
    }

    @DELETE
    @Path("/{id}")
    public String deleteLibrary(@PathParam("id") String id) throws Throwable {
        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId(id);

        return execute(libraryDto, ActivitiProcessConstants.Admin.DELETE_LIBRARY);
    }
}
