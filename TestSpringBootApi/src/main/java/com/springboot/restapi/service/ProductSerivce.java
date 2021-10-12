package com.springboot.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.domain.Products;
import com.springboot.restapi.jpa.Reposetory.ProductReposetory;

@Service
public class ProductSerivce {

	@Autowired
	private ProductReposetory productReposetory;
	
	
	
	public Products addProduct(Products product) {

		// list.add(Customer);
		productReposetory.save(product);
		return product;
	}
}
