package com.springboot.restapi.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

//@Entity
public class User {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * private int id; private int page; private int per_page; private int total;
	 * private int total_pages;
	 */

	//@ElementCollection
	//@Embedded
	private List<Data> data;
	//@Embedded
	//private Support support;

	public User() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public int getPage() { return page; }
	 * 
	 * public void setPage(int page) { this.page = page; }
	 * 
	 * public int getPer_page() { return per_page; }
	 * 
	 * public void setPer_page(int per_page) { this.per_page = per_page; }
	 * 
	 * public int getTotal() { return total; }
	 * 
	 * public void setTotal(int total) { this.total = total; }
	 * 
	 * public int getTotal_pages() { return total_pages; }
	 * 
	 * public void setTotal_pages(int total_pages) { this.total_pages = total_pages;
	 * }
	 */	
	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "User [data=" + data + "]";
	}

	

	/*
	 * public Support getSupport() { return support; }
	 * 
	 * public void setSupport(Support support) { this.support = support; }
	 */
	

}
