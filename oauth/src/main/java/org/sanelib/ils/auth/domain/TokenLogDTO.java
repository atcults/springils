package org.sanelib.ils.auth.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TokenLogDTO extends TokenDTO{

	public TokenLogDTO(TokenDTO tokenDto,String tokenAction) {
		this.setAccessToken(tokenDto.getAccessToken());
		this.setAccessTokenCreateDate(tokenDto.getAccessTokenCreateDate());
		this.setAccessTokenExpiredIn(tokenDto.getAccessTokenExpiredIn());
		this.setAuthorizationCode(tokenDto.getAuthorizationCode());
		this.setClientID(tokenDto.getClientID());
		this.setClientType(tokenDto.getClientType());
		this.setRefreshToken(tokenDto.getRefreshToken());
		this.setRefreshTokenCreatedDate(tokenDto.getRefreshTokenCreatedDate());
		this.setRefreshTokenExpiredIn(tokenDto.getRefreshTokenExpiredIn());
		this.setRequestDetails(tokenDto.getRequestDetails());
		this.setRequestSource(tokenDto.getRequestSource());
		this.setScope(tokenDto.getScope());
		this.setState(tokenDto.getState());
		this.setTokenType(tokenDto.getTokenType());
		this.setUserID(tokenDto.getUserID());
		
		this.setTokenAction(tokenAction);
	}
	public String getTokenAction() {
		return tokenAction;
	}
	public void setTokenAction(String tokenAction) {
		this.tokenAction = tokenAction;
	}
	private String tokenAction;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	
}
