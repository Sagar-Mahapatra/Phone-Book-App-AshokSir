package com.phoneBook.entites;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Contact {

	private Long contactId;

	@NotEmpty
	private String contactName;

	@NotNull
	private Long contactNumber;

	@Email
	@NotEmpty
	private String contactEmail;

}
