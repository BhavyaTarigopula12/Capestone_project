package com.ey.dto.response;

public class LoginResponse {

	private String accessToken;
	private long expiresIn;
	private UserInfo user;

	public LoginResponse(String accessToken, long expiresIn, UserInfo user) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.user = user;
	}

	public LoginResponse(String accessToken, String role) {
		this.accessToken = accessToken;

	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
