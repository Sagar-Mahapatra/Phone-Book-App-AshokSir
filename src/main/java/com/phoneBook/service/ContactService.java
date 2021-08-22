package com.phoneBook.service;

import java.util.List;

import com.phoneBook.entites.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactById(Long Id);

	boolean updateContact(Contact contact);

	boolean deleteContactById(Long Id);

}
