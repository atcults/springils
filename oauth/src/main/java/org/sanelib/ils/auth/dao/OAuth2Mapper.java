package org.sanelib.ils.auth.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.sanelib.ils.auth.domain.ClientDTO;
import org.sanelib.ils.auth.domain.TokenDTO;
import org.sanelib.ils.auth.domain.TokenLogDTO;
import org.sanelib.ils.auth.domain.UserDTO;

public interface OAuth2Mapper {

	@Select("select client_id from client where client_id=#{client_id}")
	public String isClientIdValid(@Param("client_id") String clientId);
	
	@Select("select client_secret from client where client_secret=#{client_secret}")
	public String isClientSecretValid(@Param("client_secret") final String clientSecret);

	@Select("select userid from users where username=#{username} and password=#{password}")
	public String isUserValid(@Param("username") final String userName, @Param("password") final String password);
	
	
	@Select("select * from users where username=#{username} and password=#{password}")
	@Results({
		@Result(column = "userid", property = "userID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "username", property = "userName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "password", property = "passWord", jdbcType = JdbcType.VARCHAR),
		
	})
	public UserDTO getValidUser(@Param("username") final String userName, @Param("password") final String password);
	
	
	@Select("select * from client where client_id=#{client_id} and client_secret=#{client_secret}")
	@Results({
		@Result(column = "client_id", property = "clientID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_secret", property = "clientSecret", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_name", property = "clientName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "description", property = "clientDescription", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_url", property = "clientURL", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_type", property = "clientType", jdbcType = JdbcType.VARCHAR),
		@Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
		@Result(column = "redirect_uri", property = "redirecionURI", jdbcType = JdbcType.VARCHAR),
		@Result(column = "regdate", property = "registrationDate", jdbcType = JdbcType.DATE),
	})
	public ClientDTO getValidClient(@Param("client_id") String clientId, @Param("client_secret") final String clientSecret);
	
	
	@Insert("insert into token(client_id,userid,access_token,refresh_token,token_type" +
			",scope,auth_code,state,client_type,at_created,rt_created,at_expires_in,rt_expires_in" +
			",request_source,request_detail) values(#{clientID},#{userID},#{accessToken},#{refreshToken},#{tokenType},#{scope}" +
			",#{authorizationCode},#{state},#{clientType},#{accessTokenCreateDate ,jdbcType=TIMESTAMP},#{refreshTokenCreatedDate,jdbcType=TIMESTAMP}," +
			"#{accessTokenExpiredIn,jdbcType=TIMESTAMP},#{refreshTokenExpiredIn,jdbcType=TIMESTAMP}" +
			",#{requestSource},#{requestDetails})"
	)
	public void generateToken(TokenDTO tokenDto);
	
	@Insert("insert into token_log(client_id,userid,access_token,refresh_token,token_type" +
			",scope,auth_code,state,client_type,at_created,rt_created,at_expires_in,rt_expires_in" +
			",request_source,request_detail,token_action) values(#{clientID},#{userID},#{accessToken},#{refreshToken},#{tokenType},#{scope}" +
			",#{authorizationCode},#{state},#{clientType},#{accessTokenCreateDate ,jdbcType=TIMESTAMP},#{refreshTokenCreatedDate,jdbcType=TIMESTAMP}," +
			"#{accessTokenExpiredIn,jdbcType=TIMESTAMP},#{refreshTokenExpiredIn,jdbcType=TIMESTAMP}" +
			",#{requestSource},#{requestDetails},#{tokenAction})"
	)
	public void generateTokenLog(TokenLogDTO tokenLogDto);
	
	@Select("select * from token where refresh_token=#{refresh_token}")
	@Results({
		@Result(column = "client_id", property = "clientID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "userid", property = "userID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
		@Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
		@Result(column = "token_type", property = "tokenType", jdbcType = JdbcType.VARCHAR),
		@Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
		@Result(column = "auth_code", property = "authorizationCode", jdbcType = JdbcType.VARCHAR),
		@Result(column = "state", property = "state", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_type", property = "clientType", jdbcType = JdbcType.VARCHAR),
		@Result(column = "at_created", property = "accessTokenCreateDate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "rt_created", property = "refreshTokenCreatedDate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "at_expires_in", property = "accessTokenExpiredIn", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "rt_expires_in", property = "refreshTokenExpiredIn", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "request_source", property = "requestSource", jdbcType = JdbcType.VARCHAR),
		@Result(column = "request_detail", property = "requestDetails", jdbcType = JdbcType.VARCHAR)
	})
	public TokenDTO isRefreshTokenValid(@Param("refresh_token") final String refreshToken);
	
	@Update("update token set refresh_token=#{updatedToken.refreshToken}, access_token=#{updatedToken.accessToken}" +
			", at_expires_in=#{updatedToken.accessTokenExpiredIn},rt_expires_in=#{updatedToken.refreshTokenExpiredIn} where refresh_token=#{old_refresh_token}")
	public void updateRefreshToken(@Param("updatedToken") final TokenDTO updatedToken,
			@Param("old_refresh_token") final String existingRefreshToken);
	
	
	@Select("select * from token where access_token=#{access_token}")
	@Results({
		@Result(column = "client_id", property = "clientID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "userid", property = "userID", jdbcType = JdbcType.VARCHAR),
		@Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
		@Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
		@Result(column = "token_type", property = "tokenType", jdbcType = JdbcType.VARCHAR),
		@Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
		@Result(column = "auth_code", property = "authorizationCode", jdbcType = JdbcType.VARCHAR),
		@Result(column = "state", property = "state", jdbcType = JdbcType.VARCHAR),
		@Result(column = "client_type", property = "clientType", jdbcType = JdbcType.VARCHAR),
		@Result(column = "at_created", property = "accessTokenCreateDate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "rt_created", property = "refreshTokenCreatedDate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "at_expires_in", property = "accessTokenExpiredIn", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "rt_expires_in", property = "refreshTokenExpiredIn", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "request_source", property = "requestSource", jdbcType = JdbcType.VARCHAR),
		@Result(column = "request_detail", property = "requestDetails", jdbcType = JdbcType.VARCHAR)
	})
	public TokenDTO isAccessTokenValid(@Param("access_token") final String accessToken);
}
