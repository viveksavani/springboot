package com.springboot.restapi.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Embeddable
@Entity
public class Data {

	@Id
	@Column(name = "data_id")
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Data(int id, String email, String first_name, String last_name, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", avatar=" + avatar + "]";
	}
	
}
