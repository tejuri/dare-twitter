package com.twitter.dare.daretwitter.security;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	private String userId;
	private String password;

	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String userId, String password) {
		this.setUserId(userId);
		this.setPassword(password);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequest [userId=" + userId + ", password=" + password + "]";
	}

}
