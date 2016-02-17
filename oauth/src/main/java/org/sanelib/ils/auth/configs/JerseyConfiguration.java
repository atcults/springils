package org.sanelib.ils.auth.configs;

import org.glassfish.jersey.server.ResourceConfig;
import org.sanelib.ils.auth.endpoints.OAuthServerEndpoint;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration(){
		register(OAuthServerEndpoint.class);

	}
}
