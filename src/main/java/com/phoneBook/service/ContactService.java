package com.phoneBook.service;

import java.util.List;

import com.phoneBook.entites.Contact;
import com.phoneBook.entites.ContactEntity;

public interface ContactService {

	boolean saveContact(Contact contact);

	List<Contact> getAllContacts();

	ContactEntity getContactById(Long Id);

	boolean deleteContactById(Long Id);

}
