package com.springboot.restapi.domain;

import java.util.Arrays;
import java.util.List;

public class stock {


	private List<Metadata> data;

	public List<Metadata> getData() {
		return data;
	}

	public void setData(List<Metadata> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "stock [data=" + data + "]";
	}


	
	
	
	
}
