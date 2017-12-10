package com.twitter.dare.daretwitter.models;

import java.io.Serializable;

public class LoginRequestVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 872213391587359964L;
	String userName;
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestVO [userName=" + userName + ", password=" + password + "]";
	}

}
