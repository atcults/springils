package org.sanelib.ils.api.services.binderOrder;

import org.sanelib.ils.api.converters.binderOrder.BinderOrderViewConverter;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.dao.read.admin.BinderOrderViewRepository;
import org.sanelib.ils.core.domain.view.admin.BinderOrderView;
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
@Path(ApiEndPointConstants.Admin.BINDERORDER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class BinderOrderService extends ApiServiceBase {

    @Autowired
    BinderOrderViewRepository binderOrderViewRepository;

    @Autowired
    BinderOrderViewConverter binderOrderViewConverter;

    @GET
    @SuppressWarnings("unchecked")
    public List getAllBinderOrder() throws Throwable {
        List dtoList = new ArrayList<>();
        List viewList = binderOrderViewRepository.getAll();

        dtoList.addAll((Collection) viewList.stream().map(v -> binderOrderViewConverter.convert((BinderOrderView) v)).collect(Collectors.toList()));

        return dtoList;
    }

    @POST
    public String addBinderOrder(BinderOrderDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.ADD_BINDERORDER);
    }

    @PUT
    public String updateBinderOrder(BinderOrderDto dto) throws Throwable {
        return execute(dto, ActivitiProcessConstants.Admin.UPDATE_BINDERORDER);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteBinderOrder(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        BinderOrderDto binderOrderDto = new BinderOrderDto();

        binderOrderDto.setLibraryId(libraryId);
        binderOrderDto.setId(id);

        return execute(binderOrderDto, ActivitiProcessConstants.Admin.DELETE_BINDERORDER);
    }
}
