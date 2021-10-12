package com.springboot.restapi.domain;

public class Metadata {


	private int id;
	private String employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Metadata [id=" + id + ", employee=" + employee + "]";
	}



	
	
	
}
