package org.sanelib.ils.auth.domain;

import java.util.Date;

public class ClientDTO {

	public ClientDTO(){}
	
	private String clientID;
	private String clientSecret;
	private String clientName;
	private String clientDescription;
	private String clientURL;
	private String clientType;
	private String scope;
	private String redirecionURI;
	private Date registrationDate;
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientDescription() {
		return clientDescription;
	}
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	public String getClientURL() {
		return clientURL;
	}
	public void setClientURL(String clientURL) {
		this.clientURL = clientURL;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getRedirecionURI() {
		return redirecionURI;
	}
	public void setRedirecionURI(String redirecionURI) {
		this.redirecionURI = redirecionURI;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
}
