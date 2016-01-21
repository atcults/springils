package org.sanelib.ils.api.services.serialBoundVolume;

import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
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
@Path(ApiEndPointConstants.Admin.SERIALBOUNDVOLUME_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class SerialBoundVolumeService extends ApiServiceBase {

    @GET
    public List getAllAgencies() throws Throwable {
        List<SerialBoundVolumeDto> list = new ArrayList<>();
        SerialBoundVolumeDto serialBoundVolumeDto = new SerialBoundVolumeDto();

        serialBoundVolumeDto.setId("1");
        serialBoundVolumeDto.setLibraryId("1");
        serialBoundVolumeDto.setName("SerialBoundVolume");
        serialBoundVolumeDto.setColor("Color");
        serialBoundVolumeDto.setPrice("10.10");
        serialBoundVolumeDto.setEntryId("EntryId");
        serialBoundVolumeDto.setEntryDate("2015/11/11");

        list.add(serialBoundVolumeDto);

        return list;
    }

    @POST
    public String addSerialBoundVolume(SerialBoundVolumeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_SERIALBOUNDVOLUME);
    }

    @PUT
    public String updateSerialBoundVolume(SerialBoundVolumeDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_SERIALBOUNDVOLUME);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteSerialBoundVolume(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        SerialBoundVolumeDto serialBoundVolumeDto = new SerialBoundVolumeDto();

        serialBoundVolumeDto.setLibraryId(libraryId);
        serialBoundVolumeDto.setId(id);

        return execute(serialBoundVolumeDto, ActivitiProcessConstants.Admin.DELETE_SERIALBOUNDVOLUME);
    }
}