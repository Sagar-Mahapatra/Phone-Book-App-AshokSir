package com.phoneBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phoneBook.entites.Contact;
import com.phoneBook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepo;

	public ContactServiceImpl(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean saveContact(Contact contact) {
		System.out.println("----------saveContact() in ContactServiceImpl class executed--------");

		Contact save = contactRepo.save(contact);
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

		List<Contact> findAll = contactRepo.findAll();

		return findAll;
	}

	@Override
	public Contact getContactById(Long Id) {
		System.out.println("----------getContactById() in ContactServiceImpl class executed--------");
		Optional<Contact> findById = contactRepo.findById(Id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Long Id) {
		System.out.println("----------deleteContactById() in ContactServiceImpl class executed--------");
		boolean status = contactRepo.existsById(Id);
		if (status) {
			contactRepo.deleteById(Id);
			return true;
		} else {
			return false;
		}

	}

}
