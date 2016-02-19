package org.sanelib.ils.api.services;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.sanelib.ils.api.errorhandling.AppExceptionMapper;
import org.sanelib.ils.api.errorhandling.GenericExceptionMapper;
import org.sanelib.ils.api.errorhandling.NotFoundExceptionMapper;
import org.sanelib.ils.api.filters.CORSResponseFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.sanelib.ils.api.filters.OAuthorizationFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        packages("org.sanelib.ils.api.services");

        //register exception handling
        register(GenericExceptionMapper.class);
        register(AppExceptionMapper.class);
        register(NotFoundExceptionMapper.class);

        //register filters
        register(CORSResponseFilter.class);
		register(OAuthorizationFilter.class);

        //register features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
