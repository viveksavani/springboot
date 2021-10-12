package com.springboot.restapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
public class Products {

	@Id
	private Long id;
	private String title;
	@Column(length = 9000)
	@Type(type="text")
	private String body_html;
	private String vendor;
	private String product_type;
	private String created_at;
	private String handle;
	private String updated_at;
	private String published_at;
	private String template_suffix;
	@Column(length = 9000)
	@Type(type="text")
	private String tags;
	private String admin_graphql_api_id;
	private Image image;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Variants> variants;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Images> images;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Options> options;
	
	
	
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
	}
	public List<Variants> getVariants() {
		return variants;
	}
	public void setVariants(List<Variants> variants) {
		this.variants = variants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody_html() {
		return body_html;
	}
	public void setBody_html(String body_html) {
		this.body_html = body_html;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getPublished_at() {
		return published_at;
	}
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}
	public String getTemplate_suffix() {
		return template_suffix;
	}
	public void setTemplate_suffix(String template_suffix) {
		this.template_suffix = template_suffix;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAdmin_graphql_api_id() {
		return admin_graphql_api_id;
	}
	public void setAdmin_graphql_api_id(String admin_graphql_api_id) {
		this.admin_graphql_api_id = admin_graphql_api_id;
	}
	
	

	
	@Override
	public String toString() {
		return "Products [id=" + id + ", title=" + title + ", body_html=" + body_html + ", vendor=" + vendor
				+ ", product_type=" + product_type + ", created_at=" + created_at + ", handle=" + handle
				+ ", updated_at=" + updated_at + ", published_at=" + published_at + ", template_suffix="
				+ template_suffix + ", tags=" + tags + ", admin_graphql_api_id=" + admin_graphql_api_id + "]";
	}
	
	
	

}
