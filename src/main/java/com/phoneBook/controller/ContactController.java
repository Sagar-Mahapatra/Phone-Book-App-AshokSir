package com.phoneBook.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoneBook.AppConstants;
import com.phoneBook.entites.Contact;
import com.phoneBook.entites.ContactEntity;
import com.phoneBook.props.AppProps;
import com.phoneBook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private AppProps appProps;

//	Form load hander
	@GetMapping("/Contact Info")
	public String loadForm(Model model) {

		model.addAttribute(AppConstants.CONTACT, new Contact());
		return AppConstants.CONTACTS_PAGE;
	}

//	Save Contact handler
	@PostMapping(value = "/save_contact")
	public String saveContact(@Valid Contact contact, BindingResult result, Model model) {

		Map<String, String> messages = appProps.getMessages();

		if (result.hasErrors()) {
			return AppConstants.CONTACTS_PAGE;
		}

		if (contactService.saveContact(contact)) {

			model.addAttribute(AppConstants.SAVE_SUCCESS, messages.get("saveSuccess"));

		}

		else {

			model.addAttribute(AppConstants.SAVE_ERROR, messages.get("saveFail"));

		}

		return AppConstants.CONTACTS_PAGE;

	}

// View All Contacts
	@GetMapping("/viewAllcontacts")
	public String viewAllContacts(Model model) {

		List<ContactEntity> allContacts = contactService.getAllContacts();

		model.addAttribute(AppConstants.ALL_CONTACTS, allContacts);
		return AppConstants.VIEWCONTACTS_PAGE;

	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Long contactId, Model model) {

		ContactEntity contactById = contactService.getContactById(contactId);
		model.addAttribute(AppConstants.CONTACT, contactById);

		return AppConstants.CONTACTS_PAGE;

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Long contactId, Model model) {

		Map<String, String> messages = appProps.getMessages();

		boolean Is_Deleted = contactService.deleteContactById(contactId);
		if (Is_Deleted) {
			model.addAttribute(AppConstants.DELETE_SUCCESS, messages.get("deleteSuccess"));
		} else {
			model.addAttribute(AppConstants.DELETE_ERROR, messages.get("deleteFail"));
		}

		return "redirect:/viewAllcontacts";

	}

}
