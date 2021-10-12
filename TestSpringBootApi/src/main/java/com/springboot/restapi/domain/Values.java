package com.springboot.restapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;


public class Values {

	private String values;
	
	private List<Options> options;

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
	
	
	
}
