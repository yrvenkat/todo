package org.vrpowerz.todo.model;

import java.nio.ByteBuffer;

public class OAuth2AccessTokenBuilder {

	private String token_id;
    private ByteBuffer token_object;
    private String authentication_id;
    private String user_name;
    private String client_id;
    private ByteBuffer authentication;
    private String refresh_token;
    

    public OAuth2AccessTokenBuilder tokenId(String token_id) {
        this.token_id = token_id;
        return this;
    }

    public OAuth2AccessTokenBuilder tokenObject(ByteBuffer token_object) {
        this.token_object = token_object;
        return this;
    }

    public OAuth2AccessTokenBuilder authenticationId(String authentication_id) {
        this.authentication_id = authentication_id;
        return this;
    }

    public OAuth2AccessTokenBuilder userName(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public OAuth2AccessTokenBuilder clientId(String client_id) {
        this.client_id = client_id;
        return this;
    }

    public OAuth2AccessTokenBuilder authentication(ByteBuffer authentication) {
        this.authentication = authentication;
        return this;
    }

    public OAuth2AccessTokenBuilder refreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public OAuth2AccessToken build() {
        return new OAuth2AccessToken(token_id, token_object, authentication_id, user_name, client_id, authentication, refresh_token);
    }
	
}
