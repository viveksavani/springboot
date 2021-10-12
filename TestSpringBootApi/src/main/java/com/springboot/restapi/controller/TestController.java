package com.springboot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.domain.Data;
import com.springboot.restapi.jpa.Entity.Customer;
import com.springboot.restapi.jpa.Reposetory.DataReposetory;
import com.springboot.restapi.service.CustomerService;
import com.springboot.restapi.service.DataService;

@RestController
public class TestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DataService dataService;
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomer() {

		List<Customer> customer = customerService.getCustomers();

		if (customer.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
		Customer customer = null;
		customer = customerService.getCustomerById(id);
		if (customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		try {
			customerService.addCustomer(customer);
			return ResponseEntity.of(Optional.of(customer));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int id) {
		try {
			customerService.deleteCustomer(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		try {
			customerService.updateCustomer(id, customer);
			return ResponseEntity.of(Optional.of(customer));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@PostMapping("/users")
	public ResponseEntity<Data> addData(@RequestBody Data data) {
		try {
			dataService.addCustomer(data);
			return ResponseEntity.of(Optional.of(data));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Data> updateData(@PathVariable("id") int id, @RequestBody Data data) {
		try {
			dataService.updateCustomer(id, data);
			return ResponseEntity.of(Optional.of(data));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteData(@PathVariable("id") int id) {
		try {
			dataService.deleteCustomer(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Data>> getData() {

		List<Data> data = dataService.getData();

		if (data.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(data));
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Data> getDataById(@PathVariable("id") int id) {
		Data data = null;
		data = dataService.getDataById(id);
		if (data == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(data));
	}
	

}
