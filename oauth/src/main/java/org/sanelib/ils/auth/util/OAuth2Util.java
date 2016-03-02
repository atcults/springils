package org.sanelib.ils.auth.util;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class OAuth2Util {
	
	private static final Logger LOG = LoggerFactory.getLogger(OAuth2Util.class);

	public static OAuthResponse buildAccessTokenResponseForPassWordGrantType(int tokenResponse,
			String redirectionURI,String accessToken,String refreshToken,String tokenType,String expiredIn){
		OAuthResponse oAuthResponse = null;
		try{
			
			oAuthResponse = OAuthASResponse
					.tokenResponse(tokenResponse)
					.location(redirectionURI)
					.setAccessToken(accessToken)
					.setRefreshToken(refreshToken)
					.setTokenType(tokenType)
					.setExpiresIn(expiredIn)
					.buildJSONMessage();
			
		}
		catch(Exception e){
			LOG.error("Exception occured while building OAuth Response :"+e.getMessage());
		}
		return oAuthResponse;
	}
	
	public static OAuthResponse buildErrorOAuthResponse(int errorResponse,String error,String errorDescription){
		OAuthResponse oAuthResponse = null;
		try{
			
			oAuthResponse = OAuthASResponse
			.errorResponse(errorResponse)
			.setError(error)
			.setErrorDescription(errorDescription)
			.buildJSONMessage();
			
		}
		catch(Exception e){
			LOG.error("Exception occured while building OAuth Error Response :"+e.getMessage());
		}
		return oAuthResponse;
	}
}
