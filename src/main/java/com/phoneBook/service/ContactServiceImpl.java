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
		try {
			System.out.println("----------try block in saveContact() in ContactServiceImpl class executed--------");
			contactRepo.save(contact);
			return true;
		} catch (Exception e) {
			System.out.println("----------catch block in saveContact() in ContactServiceImpl class executed--------");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = null;
		System.out.println("----------getAllContacts() in ContactServiceImpl class executed--------");
		try {
			list = contactRepo.findAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}

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
	public boolean updateContact(Contact contact) {
		System.out.println("----------updateContact() in ContactServiceImpl class executed--------");
		try {
			System.out.println("----------try block in updateContact() in ContactServiceImpl class executed--------");
			contactRepo.save(contact);
			return true;
		} catch (Exception e) {
			System.out
					.println("----------catch bloack in updateContact() in ContactServiceImpl class executed--------");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteContactById(Long Id) {
		System.out.println("----------deleteContactById() in ContactServiceImpl class executed--------");
		try {
			System.out.println(
					"---------- try block in deleteContactById() in ContactServiceImpl class executed--------");
			Contact contact = contactRepo.findById(Id).get();

			contactRepo.delete(contact);
			return true;
		} catch (Exception e) {
			System.out.println(
					"----------catch block in deleteContactById() in ContactServiceImpl class executed--------");
			e.printStackTrace();
			return false;
		}

	}

}
