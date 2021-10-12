package com.springboot.restapi.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Productwrapper {

	private List<Products> products;
	
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Productwrapper [products=" + products  + "]";
	}

	
	



	
}
