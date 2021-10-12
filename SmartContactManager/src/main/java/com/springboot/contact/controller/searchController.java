package com.springboot.contact.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.contact.Entity.Contact;
import com.springboot.contact.Entity.User;
import com.springboot.contact.repo.ContactRepo;
import com.springboot.contact.repo.UserRepo;

@RestController
public class searchController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ContactRepo contactRepo;
	

	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query,Principal principal){
		
		System.out.println(query);
		
		String name = principal.getName();
		User user = userRepo.getUserByName(name);
		
		List<Contact> contacts = contactRepo.findByNameContainingAndUser(query, user);
		
		return ResponseEntity.ok(contacts);
	}
	
	
}
