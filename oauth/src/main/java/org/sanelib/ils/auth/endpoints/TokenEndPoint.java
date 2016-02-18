package org.sanelib.ils.auth.endpoints;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.TokenType;

import org.sanelib.ils.auth.dao.OAuth2Repository;
import org.sanelib.ils.auth.domain.ClientDTO;
import org.sanelib.ils.auth.domain.TokenDTO;
import org.sanelib.ils.auth.domain.TokenLogDTO;
import org.sanelib.ils.auth.domain.UserDTO;
import org.sanelib.ils.auth.util.OAuth2Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/token")
public class TokenEndPoint {

	private static final Logger LOG = LoggerFactory.getLogger(TokenEndPoint.class);
	
	private final static String TOKEN_ACTION_UPDATE = "UPDATE";
	
	@Autowired OAuth2Repository oAuthRepository;
	
	@Autowired
	Environment env;
	
	
	@POST
	public Response accessToken(@Context HttpServletRequest request){
		
		final String client_id = request.getParameter(OAuth.OAUTH_CLIENT_ID);
		final String client_secret = request.getParameter(OAuth.OAUTH_CLIENT_SECRET);
		final String username = request.getParameter(OAuth.OAUTH_USERNAME);
		final String password = request.getParameter(OAuth.OAUTH_PASSWORD);
		final String grant_type = request.getParameter(OAuth.OAUTH_GRANT_TYPE);
		final String redirect_uri = request.getParameter(OAuth.OAUTH_REDIRECT_URI);
		final String refresh_token = request.getParameter(OAuth.OAUTH_REFRESH_TOKEN);
		
		final String access_token_expired = env.getProperty("oauth.token.access.expired");
		final String refresh_token_expired = env.getProperty("oauth.token.refresh.expired");
		
		ClientDTO clientDTO = null;
		UserDTO userDTO = null;
		
		
		try{

			if (StringUtils.equals(grant_type, GrantType.PASSWORD.name())) {
				
				clientDTO = oAuthRepository.getValidClient(client_id, client_secret);
				
				if(clientDTO == null){
					OAuthResponse response = OAuthASResponse
							.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
							.setError(OAuthError.CodeResponse.UNAUTHORIZED_CLIENT)
							.setErrorDescription("Client Credentials are not Authorized.")
							.buildJSONMessage();
					return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
				}
				
				userDTO = oAuthRepository.getValidUser(username, password);
				
				if(userDTO != null){
					
					OAuthIssuerImpl oAuthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
					
					String accessToken = oAuthIssuerImpl.accessToken();
					String refreshToken = oAuthIssuerImpl.refreshToken();
					Calendar accessTokenCreated = Calendar.getInstance();
					Calendar refreshTokenCreated = Calendar.getInstance();
					
					Calendar accessTokenExpired = Calendar.getInstance();
					accessTokenExpired.add(Calendar.SECOND, new Integer(access_token_expired));
					
					Calendar refreshTokenExpired = Calendar.getInstance();
					refreshTokenExpired.add(Calendar.SECOND,  new Integer(refresh_token_expired));
							
					
					TokenDTO newTokenDto = new TokenDTO(clientDTO.getClientID(), userDTO.getUserID(), accessToken,
							refreshToken, "Bearer", null,
							null, null, null,
							accessTokenCreated.getTime(), refreshTokenCreated.getTime(),
							accessTokenExpired.getTime(), refreshTokenExpired.getTime(),
							null, null);
					
					
					OAuthResponse oAuthResponse = null;
					try{
						oAuthRepository.generateToken(newTokenDto);
						oAuthResponse = OAuth2Util
								.buildAccessTokenResponseForPassWordGrantType(HttpServletResponse.SC_OK, redirect_uri, accessToken,
								refreshToken, TokenType.BEARER.toString(), access_token_expired);
						
					}
					catch(Exception e){
						LOG.error("Exception occured while Generating Access Token :"+e.getMessage());
						OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, OAuthError.OAUTH_ERROR, "Token Generation Fail");
						return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
					}
					
						
					return 	Response.status(oAuthResponse.getResponseStatus())
							.entity(oAuthResponse.getBody())
							.location(new URI(oAuthResponse.getLocationUri()))
							.build();
				
			}
			else{
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_UNAUTHORIZED, OAuthError.TokenResponse.UNAUTHORIZED_CLIENT, "Invalid Username/Password.");
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
			
				
			}
			else if(StringUtils.equals(grant_type, GrantType.CLIENT_CREDENTIALS.name())){
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_BAD_REQUEST, OAuthError.TokenResponse.UNSUPPORTED_GRANT_TYPE, "UnSupported Grant Type");
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
			else if(StringUtils.equals(grant_type, GrantType.AUTHORIZATION_CODE.name())){
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_BAD_REQUEST, OAuthError.TokenResponse.UNSUPPORTED_GRANT_TYPE, "UnSupported Grant Type");
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
			else if(StringUtils.equals(grant_type, GrantType.IMPLICIT.name())){
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_BAD_REQUEST, OAuthError.TokenResponse.UNSUPPORTED_GRANT_TYPE, "UnSupported Grant Type");
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
			else if(StringUtils.equals(grant_type, GrantType.REFRESH_TOKEN.name())){
				
				if(StringUtils.isEmpty(refresh_token)){
					OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_BAD_REQUEST, OAuthError.TokenResponse.INVALID_REQUEST, "Refresh Token is required when Grant Type is Refresh Token");

					return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
				}
				else{
					TokenDTO refreshToken = oAuthRepository.isRefreshTokenValid(refresh_token);
					
					if(refreshToken != null){
						
						Date currentTime = Calendar.getInstance().getTime();
						
						if(currentTime.before(refreshToken.getRefreshTokenExpiredIn())){
							
							MD5Generator newAccessTokenGenerator = new MD5Generator();
							String newAccessToken = newAccessTokenGenerator.generateValue();
							
							MD5Generator newRefreshTokenGenerator = new MD5Generator();
							String newRefreshToken = newRefreshTokenGenerator.generateValue();
							
							
							TokenDTO updatedToken = refreshToken.clone();
							updatedToken.setAccessToken(newAccessToken);
							updatedToken.setRefreshToken(newRefreshToken);
							
							Calendar updatedAccessTokenExpired = Calendar.getInstance();
							updatedAccessTokenExpired.add(Calendar.SECOND, new Integer(access_token_expired));
							updatedToken.setAccessTokenExpiredIn(updatedAccessTokenExpired.getTime());
							
							Calendar updatedRefreshTokenExpired = Calendar.getInstance();
							updatedRefreshTokenExpired.add(Calendar.SECOND, new Integer(refresh_token_expired));
							updatedToken.setRefreshTokenExpiredIn(updatedRefreshTokenExpired.getTime());
							OAuthResponse oAuthResponse = null;
							try{
								oAuthRepository.updateRefreshToken(updatedToken,refreshToken.getRefreshToken());
								oAuthResponse = OAuth2Util.buildAccessTokenResponseForPassWordGrantType(HttpServletResponse.SC_OK, redirect_uri, newAccessToken,
										newRefreshToken, TokenType.BEARER.toString(), access_token_expired);
								
							}
							catch(Exception e){
								LOG.error("Exception occured while Updating Refresh and Access Tokens :"+e.getMessage());
								OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, OAuthError.CodeResponse.SERVER_ERROR, "Exception occured while updating Refresh Token");
								
								return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
							}
							
							try{
								TokenLogDTO tokenLog = new TokenLogDTO(refreshToken, TokenEndPoint.TOKEN_ACTION_UPDATE);
								oAuthRepository.generateTokenLog(tokenLog);
							}
							catch(Exception e){
								LOG.error("Exception occured while generating token log event :"+e.getMessage());
							}
							
							return 	Response.status(oAuthResponse.getResponseStatus())
									.entity(oAuthResponse.getBody())
									.build();
						}
						else{
							OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_OK, OAuthError.ResourceResponse.EXPIRED_TOKEN, "Refresh Token is expired.");
							return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
						}
						
						
					}
					else{
						OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_OK, OAuthError.ResourceResponse.INVALID_TOKEN, "Refresh Token is not valid");
						return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
					}
					
				}
				
			}
			else{
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_OK, OAuthError.TokenResponse.UNSUPPORTED_GRANT_TYPE, "UnSupported Grant Type");
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
		
			
		}
		catch(Exception e){
			LOG.error("Exception Occurred in Token Endpoint :"+ e.getMessage());
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		//Un commenting below line should give compilation error which means you covered all if..else block.
		//return null;
	}
	
	@Path("/validate")
	@GET
	public Response accessTokenValidate(@Context HttpServletRequest request){
		try{
			
			String access_token = request.getParameter(OAuth.OAUTH_ACCESS_TOKEN);
			TokenDTO accessTokenDto = oAuthRepository.isAccessTokenValid(access_token);
			
			if(accessTokenDto != null){
				Date currentTime = Calendar.getInstance().getTime();
				
				if(!currentTime.before(accessTokenDto.getAccessTokenExpiredIn())){
					OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_OK, OAuthError.ResourceResponse.EXPIRED_TOKEN, "AccessToken is expired");
					return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
				}
				else{
					
					OAuthResponse oAuthResponse = OAuthASResponse
							.tokenResponse(HttpServletResponse.SC_OK)
							.setParam("valid", "true")
							.setParam("userID", accessTokenDto.getUserID())
							.setParam("scope", accessTokenDto.getScope())
							.buildJSONMessage();
					
					return 	Response.status(oAuthResponse.getResponseStatus())
							.entity(oAuthResponse.getBody())
							.build();
				}
			}
			else{
				OAuthResponse response = OAuth2Util.buildErrorOAuthResponse(HttpServletResponse.SC_OK, OAuthError.ResourceResponse.INVALID_TOKEN, "AccessToken is not valid");
				
				return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
			}
			
			
		}
		catch(Exception e){
			LOG.error("Exception Occured while Validating Access Token :"+e.getMessage());
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			
		}
		
		//Un commenting below line should give compilation error which means you covered all if..else block.
		//return null;
	}
	
}
