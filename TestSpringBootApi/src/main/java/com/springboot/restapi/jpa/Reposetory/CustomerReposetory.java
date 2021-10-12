package com.springboot.restapi.jpa.Reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.springboot.restapi.jpa.Entity.Customer;

@Service
public interface CustomerReposetory extends CrudRepository<Customer,Integer> {

	
	public Customer findById(int id);
}
