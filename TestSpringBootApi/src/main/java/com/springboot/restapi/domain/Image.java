package com.springboot.restapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Image {

	@Column(name = "image_id")
	private Long id;
	@Column(name = "image_product_id")
	private Long product_id;
	@Column(name = "image_position")
	private int position;
	@Column(name = "created_image_at")
	private String created_at;
	@Column(name = "updated_image_at")
	private String updated_at;
	@Column(name = "image_alt")
	private String alt;
	@Column(name = "iamge_width")
	private int width;
	@Column(name = "image_height")
	private int height;
	@Column(name = "image_src")
	private String src;
	@ElementCollection
	private List<String> variant_ids;
	@Column(name = "admin_graphql_api_image_id")
	private String admin_graphql_api_id;

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

	public List<String> getVariant_ids() {
		return variant_ids;
	}

	public void setVariant_ids(List<String> variant_ids) {
		this.variant_ids = variant_ids;
	}

	public String getAdmin_graphql_api_id() {
		return admin_graphql_api_id;
	}

	public void setAdmin_graphql_api_id(String admin_graphql_api_id) {
		this.admin_graphql_api_id = admin_graphql_api_id;
	}

}
