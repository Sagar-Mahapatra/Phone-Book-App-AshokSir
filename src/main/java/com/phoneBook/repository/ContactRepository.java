package com.phoneBook.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phoneBook.entites.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	@Query(value="select * from contact where is_active='Y'",nativeQuery = true)
	public List<Contact> getAllActiveContacts();
	
}
