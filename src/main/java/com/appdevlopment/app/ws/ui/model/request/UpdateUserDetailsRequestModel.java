package com.appdevlopment.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "first name cannot be null")
	@Size(min = 3, message = "first name must be equal or greater than 3 characters")
	private String firstName;

	@NotNull(message = "last name cannot be null")
	@Size(min = 3, message = "last name must be equal or greater than 3 characters")
	private String lastName;

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

}
