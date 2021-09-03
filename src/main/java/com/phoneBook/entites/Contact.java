package com.phoneBook.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Long contactId;

	@Column(name = "contact_name")
	@NotNull
	private String contactName;

	@Column(name = "contact_no")
	@NotNull
	private Long contactNumber;

	@Column(name = "contact_email")
	@Email
	@NotNull
	private String contactEmail;

	@Column(name = "is_active")
	private Character isActive;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updatedDate;

}
