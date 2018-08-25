package com.ymhase.miniTwit.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class RegistrationDto {

	@NotNull
	private String firstname;

	@NotNull
	private String lastname;

	@NotNull
	private String username;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 5, message = "Length of password should be of 5 charachter")
	private String password;

	@NotNull
	@Size(min = 5, message = "Length of password should be of 5 charachter")
	private String confirmPassword;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
