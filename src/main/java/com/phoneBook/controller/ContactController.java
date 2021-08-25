package com.phoneBook.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phoneBook.entites.Contact;
import com.phoneBook.helper.Message;
import com.phoneBook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/Contact Info")
	public String loadForm(Model model) {
		System.out.println("-------loadForm() in controller executed----------");
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	@PostMapping(value = "/save_contact")
	public String saveContact(@RequestBody Contact contact, HttpSession session, Model model) {

		System.out.println("Contact::  " + contact);
		System.out.println("-------saveContact() in controller  executed----------");
		if (contactService.saveContact(contact)) {
			System.out.println("-------if block in controller saveContact() executed----------");
			session.setAttribute("message",
					new Message("-------Contact Saved Successfully----------", "alert-success"));
			model.addAttribute("contact", new Contact());
		}

		else {
			System.out.println("-------else block in controller saveContact() executed----------");
			session.setAttribute("message",
					new Message("-------Something Went Wrong, please try again----------", "alert-danger"));
			model.addAttribute("contact", contact);
		}

		return "contact";

	}

	@GetMapping("/viewAllcontacts")
	public String viewAllContacts(Model model) {
		System.out.println("-------viewAllContacts() in controller class executed----------");
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("allContacts", allContacts);
		return "viewContacts";

	}

	@PostMapping("/editContact/{contactId}")
	public String editContact(@PathVariable Long contactId, Model model) {
		System.out.println("-------editContact() in controller class executed----------");
		Contact contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);
		return "updateContact";

	}

	@PostMapping("/update_contact")
	public String updateContact(@RequestBody Contact contact, Model model, HttpSession session) {

		System.out.println("-------updateContact() in controller class executed----------");
		System.out.println("contact_id:: " + contact.getContactId());
		boolean res = contactService.saveContact(contact);
		if (res) {
			model.addAttribute("contact", new Contact());
			session.setAttribute("message", new Message("Contact Updated Successfully...", "alert-success"));
		} else {
			model.addAttribute("contact", contact);
			session.setAttribute("message", new Message("Something went wrong, Please try again !!!", "alert-danger"));
		}

		return "contact";

	}

	@PostMapping("/deleteContact/{contactId}")
	public String deleteContact(@PathVariable("contactId") Long contactId, HttpSession session) {
		System.out.println("-------deleteContact() in controller class executed----------");
		boolean Is_Deleted = contactService.deleteContactById(contactId);
		if (Is_Deleted) {
			session.setAttribute("msg",
					new Message("Contact_Id: " + contactId + " Deleted Successfully...", "alert-success"));
		} else {
			session.setAttribute("msg",
					new Message("Something went wrong !!! Contact couldn't deleted", "alert-success"));
		}

		return "redirect:/viewAllcontacts";

	}

}
