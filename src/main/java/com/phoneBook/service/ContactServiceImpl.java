package com.phoneBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.phoneBook.entites.Contact;
import com.phoneBook.entites.ContactEntity;
import com.phoneBook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepo;

	public ContactServiceImpl(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity entity = new ContactEntity();
		entity.setIsActive('Y');
		System.out.println("----------saveContact() in ContactServiceImpl class executed--------");
		BeanUtils.copyProperties(contact, entity);
		ContactEntity save = contactRepo.save(entity);
		if (save != null && save.getContactId() != null) {
			System.out.println("----------if block in saveContact() in ContactServiceImpl class executed--------");
			return true;
		} else {
			System.out.println("----------catch block in saveContact() in ContactServiceImpl class executed--------");
			return false;
		}

	}

	@Override
	public List<Contact> getAllContacts() {

		System.out.println("----------getAllContacts() in ContactServiceImpl class executed--------");

		List<Contact> findAll = contactRepo.getAllActiveContacts();

		return findAll;
	}

	@Override
	public ContactEntity getContactById(Long Id) {
		System.out.println("----------getContactById() in ContactServiceImpl class executed--------");
		Optional<ContactEntity> findById = contactRepo.findById(Id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Long Id) {
		System.out.println("----------deleteContactById() in ContactServiceImpl class executed--------");
		Optional<ContactEntity> findById = contactRepo.findById(Id);
		if (findById.isPresent()) {
			ContactEntity contact = findById.get();
			contact.setIsActive('N');
			contactRepo.save(contact);
			return true;
		} else {
			return false;
		}

	}

}
