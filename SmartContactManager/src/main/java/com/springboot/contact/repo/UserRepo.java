package com.springboot.contact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.contact.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	@Query("select u From User u where u.email=:email")
	public User getUserByName(@Param("email")String email);
}
