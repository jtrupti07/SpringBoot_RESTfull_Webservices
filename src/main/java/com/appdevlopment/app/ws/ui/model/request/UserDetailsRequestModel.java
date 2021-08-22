package com.appdevlopment.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull (message="first name cannot be null")
	@Size(min=3, message="first name must be equal or greater than 3 characters")
	private String firstName;
	
	
	@NotNull (message="last name cannot be null")
	@Size(min=3, message="last name must be equal or greater than 3 characters")
	private String lastName;
	
	
	@NotNull (message="email cannot be null")
	@Email
	private String email;
	
	
	@NotNull (message="password cannot be null")
	@Size(min=8,max=16,message="password must be equal or greater than 8 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
