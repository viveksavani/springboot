package com.springboot.contact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.contact.Entity.User;
import com.springboot.contact.repo.UserRepo;

public class UserdetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getUserByName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("could not found user");
		}
		
		CustomUserDetail custom = new CustomUserDetail(user);
		return custom;
	}

}
