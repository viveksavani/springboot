package com.springboot.contact.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springboot.contact.Entity.Contact;
import com.springboot.contact.Entity.User;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

	@Query("from Contact c where c.user.id=:userId")
	public Page<Contact> getContactById(@Param("userId")int userId,Pageable pageable);
	
	
	//search
	public List<Contact> findByNameContainingAndUser(String name,User user);
}
