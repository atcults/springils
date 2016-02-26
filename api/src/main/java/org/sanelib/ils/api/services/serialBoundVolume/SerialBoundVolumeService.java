package org.sanelib.ils.api.services.serialBoundVolume;

import org.sanelib.ils.api.converters.serialBoundVolume.SerialBoundVolumeViewConverter;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.SerialBoundVolumeViewRepository;
import org.sanelib.ils.core.domain.view.admin.SerialBoundVolumeView;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ApiEndPointConstants.Admin.SERIALBOUNDVOLUME_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class SerialBoundVolumeService extends ApiServiceBase {

    @Autowired
    SerialBoundVolumeViewRepository serialBoundVolumeViewRepository;

    @Autowired
    SerialBoundVolumeViewConverter serialBoundVolumeViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllAgencies() throws Throwable {

        List dtoList = new ArrayList<>();
        List viewList = serialBoundVolumeViewRepository.getAll();

        dtoList.addAll((Collection) viewList.stream().map(v -> serialBoundVolumeViewConverter.convert((SerialBoundVolumeView) v)).collect(Collectors.toList()));

        return dtoList;
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
