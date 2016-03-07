package org.sanelib.ils.auth.endpoints;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/properties")
public class OAuthServerEndpoint {

	@Autowired
	Environment env;


	@GET
	public String getApplicationProperties(){

		Map<String,String> applicationPropertiesMap = new HashMap<String,String>();

		for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
			PropertySource propertySource = (PropertySource) it.next();
			if (propertySource instanceof MapPropertySource) {
				MapPropertySource mapSource = (MapPropertySource) propertySource;

				for(Map.Entry<String,Object> entrySet : mapSource.getSource().entrySet()){
					if(entrySet.getKey().contains("oauth")){
						applicationPropertiesMap.put(entrySet.getKey(), entrySet.getValue().toString());
					}
				}
			}
		}


		return applicationPropertiesMap.toString();

	}
}
