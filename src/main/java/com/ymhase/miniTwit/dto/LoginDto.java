package com.ymhase.miniTwit.dto;

import javax.validation.constraints.NotNull;

public class LoginDto {

	@NotNull(message = "User name can not be null")
	private String username;
	@NotNull
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
