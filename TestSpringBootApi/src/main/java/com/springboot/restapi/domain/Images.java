package com.springboot.restapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Images {
	
	@Id
	private Long id;
	private Long product_id;
	private int position;
	private String created_at;
	private String updated_at;
	private String alt;
	private int width;
	private int height;
	private String src;
	@ElementCollection
	private List<String> variant_ids;
	private String admin_graphql_api_id;
	
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "images")
	private List<Products> products; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getAdmin_graphql_api_id() {
		return admin_graphql_api_id;
	}
	public void setAdmin_graphql_api_id(String admin_graphql_api_id) {
		this.admin_graphql_api_id = admin_graphql_api_id;
	}
	
	public List<String> getVariant_ids() {
		return variant_ids;
	}
	public void setVariant_ids(List<String> variant_ids) {
		this.variant_ids = variant_ids;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	
}
