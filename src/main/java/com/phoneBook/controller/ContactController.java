package com.phoneBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoneBook.entites.Contact;
import com.phoneBook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

//	Form load hander
	@GetMapping("/Contact Info")
	public String loadForm(Model model) {
		System.out.println("-------loadForm() in controller executed----------");
		model.addAttribute("contact", new Contact());
		return "contacts";
	}

//	Save Contact handler
	@PostMapping(value = "/save_contact")
	public String saveContact(Contact contact, Model model) {

		System.out.println("Contact::  " + contact);
		System.out.println("-------saveContact() in controller  executed----------");

		if (contactService.saveContact(contact)) {

			System.out.println("-------if block in controller saveContact() executed----------");

			model.addAttribute("success", "Contact Saved Successfully...");

		}

		else {
			System.out.println("-------else block in controller saveContact() executed----------");

			model.addAttribute("error", "Something Went Wrong, Please try Again !!!");

		}

		return "contacts";

	}
// View All Contacts
	@GetMapping("/viewAllcontacts")
	public String viewAllContacts(Model model) {
		System.out.println("-------viewAllContacts() in controller class executed----------");
		List<Contact> allContacts = contactService.getAllContacts();
		System.out.println(allContacts);
		model.addAttribute("allContacts", allContacts);
		return "viewContacts";

	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Long contactId, Model model) {
		System.out.println("-------editContact() in controller class executed----------");
		Contact contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);
		System.out.println(contactById);
		return "contacts";

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Long contactId,Model model) {
		System.out.println("-------deleteContact() in controller class executed----------");
		boolean Is_Deleted = contactService.deleteContactById(contactId);
		if (Is_Deleted) {
			model.addAttribute("msg", "Contact Deleted...");
		} else {
			model.addAttribute("msg", "Something went Wrong !!!");
		}

		return "redirect:/viewAllcontacts";

	}

}
