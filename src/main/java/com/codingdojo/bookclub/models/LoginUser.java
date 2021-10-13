package com.codingdojo.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	@NotEmpty
	@Email
	@Size(min = 2, max = 255, message="This field is empty")
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 255, message="This field is empty")
	private String password;

	public LoginUser() {	
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
	
	
}
