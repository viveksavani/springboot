package com.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.jpa.Entity.Customer;
import com.springboot.restapi.jpa.Reposetory.CustomerReposetory;

@Service
public class CustomerService {

	@Autowired
	private CustomerReposetory customerReposetory;

	public List<Customer> getCustomers() {
		List<Customer> Customer = (List<Customer>) customerReposetory.findAll();
		return Customer;
	}

	public Customer getCustomerById(int id) {

		Customer c = null;
		/*
		 * for (Customer u : list) { if (u.getId() == id) { Customer = u; } }
		 */

		c = customerReposetory.findById(id);
		return c;
	}

	public Customer addCustomer(Customer Customer) {

		// list.add(Customer);
		customerReposetory.save(Customer);
		return Customer;
	}

	public void deleteCustomer(int id) {

		/*
		 * for (Customer u : list) { if (u.getId() == id) { list.remove(u); } }
		 */

		customerReposetory.deleteById(id);

	}

	public Customer updateCustomer(int id, Customer Customer) {

		/*
		 * for (Customer u : list) {
		 * 
		 * if (u.getId() == id) { u.setName(Customer.getName());
		 * u.setCity(Customer.getCity()); } }
		 */

		Customer.setId(id);
		Customer = customerReposetory.save(Customer);
		return Customer;
	}

}
