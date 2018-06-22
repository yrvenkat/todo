package org.vrpowerz.todo.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("oauth2_access_tokens")
public class OAuth2AccessToken implements Serializable {

	@PrimaryKey
	private String token_id;

	private ByteBuffer token_object;

	@Indexed
	private String authentication_id;

	@Indexed
	private String user_name;

	@Indexed
	private String client_id;

	private ByteBuffer authentication;

	@Indexed
	private String refresh_token;
	
	
	
	

	public OAuth2AccessToken(String token_id, ByteBuffer token_object, String authentication_id, String user_name,
			String client_id, ByteBuffer authentication, String refresh_token) {
		super();
		this.token_id = token_id;
		this.token_object = token_object;
		this.authentication_id = authentication_id;
		this.user_name = user_name;
		this.client_id = client_id;
		this.authentication = authentication;
		this.refresh_token = refresh_token;
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	public ByteBuffer getToken_object() {
		return token_object;
	}

	public void setToken_object(ByteBuffer token_object) {
		this.token_object = token_object;
	}

	public String getAuthentication_id() {
		return authentication_id;
	}

	public void setAuthentication_id(String authentication_id) {
		this.authentication_id = authentication_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public ByteBuffer getAuthentication() {
		return authentication;
	}

	public void setAuthentication(ByteBuffer authentication) {
		this.authentication = authentication;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	
	
	

}
