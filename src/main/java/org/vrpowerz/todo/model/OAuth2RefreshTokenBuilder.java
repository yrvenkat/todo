package org.vrpowerz.todo.model;

import java.nio.ByteBuffer;

public class OAuth2RefreshTokenBuilder {

	private String token_id;
	private ByteBuffer token_value;
	private ByteBuffer authentication;

	public OAuth2RefreshTokenBuilder tokenId(String token_id) {
		this.token_id = token_id;
		return this;
	}

	public OAuth2RefreshTokenBuilder tokenValue(ByteBuffer token_value) {
		this.token_value = token_value;
		return this;
	}

	public OAuth2RefreshTokenBuilder authentication(ByteBuffer authentication) {
		this.authentication = authentication;
		return this;
	}

	public OAuth2RefreshToken build() {
		return new OAuth2RefreshToken(token_id, token_value, authentication);
	}
}
