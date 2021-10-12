package com.springboot.restapi.jpa.Reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.springboot.restapi.domain.Data;
import com.springboot.restapi.jpa.Entity.Customer;

@Service
public interface DataReposetory extends CrudRepository<Data,Integer>{

	public Data findById(int id);
}
