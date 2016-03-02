package org.sanelib.ils.auth.dao;

import org.apache.commons.lang.StringUtils;

import org.sanelib.ils.auth.domain.ClientDTO;
import org.sanelib.ils.auth.domain.TokenDTO;
import org.sanelib.ils.auth.domain.TokenLogDTO;
import org.sanelib.ils.auth.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OAuth2Repository {

	@Autowired
	OAuth2Mapper oAuth2Mapper;
	
	public boolean isClientIdValid(final String clientId){
		String cID = oAuth2Mapper.isClientIdValid(clientId);
		
		if(StringUtils.isNotEmpty(cID)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isClientSecretValid(final String clientSecret){
		String cSecret = oAuth2Mapper.isClientSecretValid(clientSecret);
		
		if(StringUtils.isNotEmpty(cSecret)){
			return true;
		}
		else{
			return false;
		}
	}
	

	public UserDTO getValidUser(final String userName,final String password){
		return oAuth2Mapper.getValidUser(userName, password);
	}

	public UserDTO getUserById(final String userId){
		return oAuth2Mapper.getUserById(userId);
	}
	
	public ClientDTO getValidClient(final String clientId,final String clientSecret){
		return oAuth2Mapper.getValidClient(clientId, clientSecret);
		
	}
	
	public void generateToken(final TokenDTO tokenDto){
		oAuth2Mapper.generateToken(tokenDto);
	}
	
	public void generateTokenLog(final TokenLogDTO tokenLogDto){
		oAuth2Mapper.generateTokenLog(tokenLogDto);
	}
	
	public TokenDTO isRefreshTokenValid(final String refreshToken){
			return oAuth2Mapper.isRefreshTokenValid(refreshToken);
	}
	
	public TokenDTO isAccessTokenValid(final String accessToken){
		return oAuth2Mapper.isAccessTokenValid(accessToken);

	}
	
	public void updateRefreshToken(final TokenDTO updatedToken,final String existingRefreshToken){
		oAuth2Mapper.updateRefreshToken(updatedToken,existingRefreshToken);
	}
	
}
