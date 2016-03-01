package org.sanelib.ils.auth.domain;

import java.util.Date;

public class TokenDTO implements Cloneable{

	@Override
	public TokenDTO clone() throws CloneNotSupportedException {
		return (TokenDTO)super.clone();
	}

	public TokenDTO(String clientID, String userID, String accessToken,
			String refreshToken, String tokenType, String scope,
			String authorizationCode, String state, String clientType,
			Date accessTokenCreateDate, Date refreshTokenCreatedDate,
			Date accessTokenExpiredIn, Date refreshTokenExpiredIn,
			String requestSource, String requestDetails) {
		super();
		this.clientID = clientID;
		this.userID = userID;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.tokenType = tokenType;
		this.scope = scope;
		this.authorizationCode = authorizationCode;
		this.state = state;
		this.clientType = clientType;
		this.accessTokenCreateDate = accessTokenCreateDate;
		this.refreshTokenCreatedDate = refreshTokenCreatedDate;
		this.accessTokenExpiredIn = accessTokenExpiredIn;
		this.refreshTokenExpiredIn = refreshTokenExpiredIn;
		this.requestSource = requestSource;
		this.requestDetails = requestDetails;
	}

	public TokenDTO(){}
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	
	public Date getAccessTokenCreateDate() {
		return accessTokenCreateDate;
	}

	public void setAccessTokenCreateDate(Date accessTokenCreateDate) {
		this.accessTokenCreateDate = accessTokenCreateDate;
	}

	public Date getRefreshTokenCreatedDate() {
		return refreshTokenCreatedDate;
	}

	public void setRefreshTokenCreatedDate(Date refreshTokenCreatedDate) {
		this.refreshTokenCreatedDate = refreshTokenCreatedDate;
	}

	public Date getAccessTokenExpiredIn() {
		return accessTokenExpiredIn;
	}

	public void setAccessTokenExpiredIn(Date accessTokenExpiredIn) {
		this.accessTokenExpiredIn = accessTokenExpiredIn;
	}

	public Date getRefreshTokenExpiredIn() {
		return refreshTokenExpiredIn;
	}

	public void setRefreshTokenExpiredIn(Date refreshTokenExpiredIn) {
		this.refreshTokenExpiredIn = refreshTokenExpiredIn;
	}

	public String getRequestSource() {
		return requestSource;
	}
	public void setRequestSource(String requestSource) {
		this.requestSource = requestSource;
	}
	public String getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	private String clientID;
	private String userID;
	private String accessToken;
	private String refreshToken;
	private String tokenType;
	private String scope;
	private String authorizationCode;
	private String state;
	private String clientType;
	private Date accessTokenCreateDate;
	private Date refreshTokenCreatedDate;
	private Date accessTokenExpiredIn;
	private Date refreshTokenExpiredIn;
	private String requestSource;
	private String requestDetails;
}
