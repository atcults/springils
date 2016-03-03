package org.sanelib.ils.api.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Strings;
import org.sanelib.ils.common.properties.MapDictionaryService;
import org.sanelib.ils.common.session.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.core.env.Environment;

public class OAuthorizationFilter implements ContainerRequestFilter{

	private static final Logger LOG = LoggerFactory.getLogger(OAuthorizationFilter.class);

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER = "Bearer";
	private static final String TOKEN_ENDPOINT = "oauth.token.validate.endpoint";
	private static final String AUTH_SERVER_ENDPOINT_NOT_CONFIGURED = "common.oauth.server.endpoint.not.configured";
	private static final String AUTH_USER_REQUEST_NOT_VALID = "common.oauth.user.request.rejected";
	private static final String INTERNAL_SERVER_ERROR = "common.server.error";
	private static final String AUTH_HEADER_NOT_VALID = "common.oauth.authorization.header.not.valid";

	@Context
    HttpServletRequest request;

	@Autowired
	private Environment env;

	@Autowired
	private MapDictionaryService mapDictionaryService;

	@Autowired
    UserSession userSession;

	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		LOG.info("AuthorizationFilter is called");
		String oauthTokenValidationEndpoint = env.getProperty(TOKEN_ENDPOINT);

		if(Strings.isNullOrEmpty(oauthTokenValidationEndpoint)){
			String errorMessage = mapDictionaryService.generateMessage(AUTH_SERVER_ENDPOINT_NOT_CONFIGURED, null ,null);
			Response response = Response.status(HttpServletResponse.SC_PRECONDITION_FAILED)
					.entity(errorMessage)
					.build();
			containerRequestContext.abortWith(response);
			return;
		}

		String authorizationHeaderValue = request.getHeader(AUTHORIZATION_HEADER);

		if(!Strings.isNullOrEmpty(authorizationHeaderValue) && authorizationHeaderValue.startsWith(BEARER)){
			String[] authHeaderValues = authorizationHeaderValue.split(" ");
			if(authHeaderValues.length == 2 && !Strings.isNullOrEmpty(authHeaderValues[1])){
				String accessToken = authHeaderValues[1];
				try {
					Client client = ClientBuilder.newClient();
					WebTarget webTarget = client.target(oauthTokenValidationEndpoint + "?access_token="+accessToken);
					Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
					Response response = invocationBuilder.get();
					LOG.info("Access token["+accessToken+"] returned with status["+response.getStatus()+"]");
					if(response.getStatus() == 200){
						String jsonResponse = response.readEntity(String.class);
						JsonParser jsonParser = new BasicJsonParser();
						Map<String,Object> responseJsonMap = jsonParser.parseMap(jsonResponse);
						Boolean isValid = Boolean.valueOf((String)responseJsonMap.get("valid"));

						if(!isValid){
							Response inValidResponse = Response.status(HttpServletResponse.SC_UNAUTHORIZED)
									.build();
							containerRequestContext.abortWith(inValidResponse);
							return;
						}
						else{
							LOG.info("Access Token is valid.");
							String userID = responseJsonMap.get("userID").toString();
							String libraryID = responseJsonMap.get("libraryID").toString();
							//New UserSession is created for every request and libraryId and userId is set in it.
							userSession.setLibraryId(Integer.valueOf(libraryID));
							userSession.setUserCode(userID);

						}
					}
					else{
						LOG.error("Authorization server rejected User Request.");
						String errorMessage = mapDictionaryService.generateMessage(AUTH_USER_REQUEST_NOT_VALID, null ,null);
						Response inValidResponse = Response.status(HttpServletResponse.SC_UNAUTHORIZED)
								.entity(errorMessage)
								.build();
						containerRequestContext.abortWith(inValidResponse);
						return;
					}
				}
				catch(Exception e){
					LOG.error("Exception occurred while Authenticating request :"+e);
					String errorMessage = mapDictionaryService.generateMessage(INTERNAL_SERVER_ERROR, null ,Collections.singletonList(e.getMessage()));
					Response response = Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
							.entity(errorMessage)
							.build();
					containerRequestContext.abortWith(response);
					return;
				}
			}
			else{
				LOG.error("Authentication header value is not valid or present in the request.");
				String errorMessage = mapDictionaryService.generateMessage(AUTH_HEADER_NOT_VALID, null, null);
				Response response = Response.status(HttpServletResponse.SC_UNAUTHORIZED)
						.entity(errorMessage)
						.build();
				containerRequestContext.abortWith(response);
				return;
			}
		}
		else{
			LOG.error("Authentication header format is not valid.");
			String errorMessage = mapDictionaryService.generateMessage(AUTH_HEADER_NOT_VALID, null, null);
			Response response = Response.status(HttpServletResponse.SC_UNAUTHORIZED)
					.entity(errorMessage)
					.build();
			containerRequestContext.abortWith(response);
			return;
		}
	}
}
