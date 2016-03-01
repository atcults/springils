package org.sanelib.ils.api.errorhandling;

import org.sanelib.ils.common.properties.MapDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Collections;

@Component
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Autowired
    MapDictionaryService dictionaryService;

    public Response toResponse(Throwable ex) {

        ErrorResponse response = new ErrorResponse();

        response.addError("server", dictionaryService.generateMessage("common.server.error", null, Collections.singletonList(ex.getMessage())));

        return Response.status(500)
                .entity(response)
                .type(MediaType.APPLICATION_JSON)
                .build();
	}
}

