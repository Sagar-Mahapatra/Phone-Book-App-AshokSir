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

		BeanUtils.copyProperties(contact, entity);
		ContactEntity save = contactRepo.save(entity);

		return save != null && save.getContactId() != null;

	}

	@Override
	public List<ContactEntity> getAllContacts() {

		return contactRepo.getAllActiveContacts();
	}

	@Override
	public ContactEntity getContactById(Long Id) {

		Optional<ContactEntity> findById = contactRepo.findById(Id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Long Id) {

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
