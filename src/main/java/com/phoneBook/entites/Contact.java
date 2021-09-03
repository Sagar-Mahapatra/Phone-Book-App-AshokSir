package com.phoneBook.entites;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Contact {

	@NotNull
	private String contactName;

	@NotNull
	private Long contactNumber;

	@Email
	@NotNull
	private String contactEmail;

}
