package org.sanelib.ils.api.errorhandling;

import org.sanelib.ils.common.properties.MapDictionaryService;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component
public class AppExceptionMapper implements ExceptionMapper<AppException> {

    @Autowired
    MapDictionaryService dictionaryService;

	public Response toResponse(AppException ex) {

        ProcessError processError = ex.getProcessError();

        ErrorResponse response = new ErrorResponse();

        for (ProcessError.ErrorLine line : processError.getErrors()){
            response.addError(line.getFieldNames(), dictionaryService.generateMessage(line.getTemplate(), line.getTermNames(), line.getValues()));
        }

        return Response.status(406)
				.entity(response)
				.type(MediaType.APPLICATION_JSON)
                .build();
	}
}
