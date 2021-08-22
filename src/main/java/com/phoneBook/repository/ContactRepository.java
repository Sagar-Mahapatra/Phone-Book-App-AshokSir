package com.phoneBook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoneBook.entites.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
