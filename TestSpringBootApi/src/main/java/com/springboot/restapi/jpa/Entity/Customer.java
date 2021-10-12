package com.springboot.restapi.jpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String gender;
	
	@Column(name = "email_address")
	private String email;
	
	@Column(name = "mobile_no")
	private Long mobile;
	
	@Column(name = "address_line1")
	private String Addressline1;
	
	@Column(name = "address_line2")
	private String Addressline2;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private int zipcode;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String gender, String email, Long mobile, String addressline1,
			String addressline2, String country, String state, String city, int zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		Addressline1 = addressline1;
		Addressline2 = addressline2;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAddressline1() {
		return Addressline1;
	}

	public void setAddressline1(String addressline1) {
		Addressline1 = addressline1;
	}

	public String getAddressline2() {
		return Addressline2;
	}

	public void setAddressline2(String addressline2) {
		Addressline2 = addressline2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", mobile="
				+ mobile + ", Addressline1=" + Addressline1 + ", Addressline2=" + Addressline2 + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
}
