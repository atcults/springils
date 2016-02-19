package org.sanelib.ils.auth.configs;

import org.glassfish.jersey.server.ResourceConfig;
import org.sanelib.ils.auth.endpoints.OAuthServerEndpoint;
import org.sanelib.ils.auth.endpoints.TokenEndPoint;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(){
		register(OAuthServerEndpoint.class);
		register(TokenEndPoint.class);
	}
}
