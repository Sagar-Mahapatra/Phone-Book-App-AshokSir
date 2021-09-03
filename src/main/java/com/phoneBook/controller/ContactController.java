package com.phoneBook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoneBook.entites.Contact;
import com.phoneBook.entites.ContactEntity;
import com.phoneBook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

//	Form load hander
	@GetMapping("/Contact Info")
	public String loadForm(Model model) {

		model.addAttribute("contact", new Contact());
		return "contacts";
	}

//	Save Contact handler
	@PostMapping(value = "/save_contact")
	public String saveContact(@Valid Contact contact, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "contacts";
		}

		if (contactService.saveContact(contact)) {

			model.addAttribute("success", "Contact Saved Successfully...");

		}

		else {

			model.addAttribute("error", "Something Went Wrong, Please try Again !!!");

		}

		return "contacts";

	}

// View All Contacts
	@GetMapping("/viewAllcontacts")
	public String viewAllContacts(Model model) {

		List<ContactEntity> allContacts = contactService.getAllContacts();

		model.addAttribute("allContacts", allContacts);
		return "viewContacts";

	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Long contactId, Model model) {

		ContactEntity contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);

		return "contacts";

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Long contactId, Model model) {

		boolean Is_Deleted = contactService.deleteContactById(contactId);
		if (Is_Deleted) {
			model.addAttribute("msg", "Contact Deleted...");
		} else {
			model.addAttribute("msg", "Something went Wrong !!!");
		}

		return "redirect:/viewAllcontacts";

	}

}
