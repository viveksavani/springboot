package com.springboot.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.domain.Data;
import com.springboot.restapi.jpa.Reposetory.DataReposetory;

@Service
public class DataService {

	@Autowired
	DataReposetory dataReposetory;

	public List<Data> getData() {
		List<Data> data = (List<Data>) dataReposetory.findAll();
		return data;
	}

	public Data getDataById(int id) {

		Data data = null;
		/*
		 * for (Customer u : list) { if (u.getId() == id) { Customer = u; } }
		 */

		data = dataReposetory.findById(id);
		return data;
	}

	public Data addCustomer(Data user) {

		// list.add(Customer);
		dataReposetory.save(user);
		return user;
	}

	public Data updateCustomer(int id, Data data) {

		/*
		 * for (Customer u : list) {
		 * 
		 * if (u.getId() == id) { u.setName(Customer.getName());
		 * u.setCity(Customer.getCity()); } }
		 */

		data.setId(id);
		data = dataReposetory.save(data);
		return data;
	}

	public void deleteCustomer(int id) {

		/*
		 * for (Customer u : list) { if (u.getId() == id) { list.remove(u); } }
		 */

		dataReposetory.deleteById(id);

	}
}
