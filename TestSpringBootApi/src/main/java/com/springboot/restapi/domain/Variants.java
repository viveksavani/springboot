package com.springboot.restapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Variants {
	
	@Id
	private Long id;
	private Long product_id;
	private String title;
	private String price;
	private String sku;
	private int position;
	private String inventory_policy;
	private Double compare_at_price;
	private String fulfillment_service;
	private String inventory_management;
	private String option1;
	private String option2;
	private String option3;
	private String created_at;
	private String updated_at;
	private String taxable;
	private String barcode;
	private int grams;
	private Long image_id;
	private Double weight;
	private String weight_unit;
	private Long inventory_item_id;
	private int inventory_quantity;
	private int old_inventory_quantity;
	private String requires_shipping;
	private String admin_graphql_api_id;
	
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "variants")
	private List<Products> products;
	
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getInventory_policy() {
		return inventory_policy;
	}
	public void setInventory_policy(String inventory_policy) {
		this.inventory_policy = inventory_policy;
	}
	public Double getCompare_at_price() {
		return compare_at_price;
	}
	public void setCompare_at_price(Double compare_at_price) {
		this.compare_at_price = compare_at_price;
	}
	public String getFulfillment_service() {
		return fulfillment_service;
	}
	public void setFulfillment_service(String fulfillment_service) {
		this.fulfillment_service = fulfillment_service;
	}
	public String getInventory_management() {
		return inventory_management;
	}
	public void setInventory_management(String inventory_management) {
		this.inventory_management = inventory_management;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
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
	public String getTaxable() {
		return taxable;
	}
	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getGrams() {
		return grams;
	}
	public void setGrams(int grams) {
		this.grams = grams;
	}
	public Long getImage_id() {
		return image_id;
	}
	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getWeight_unit() {
		return weight_unit;
	}
	public void setWeight_unit(String weight_unit) {
		this.weight_unit = weight_unit;
	}
	public Long getInventory_item_id() {
		return inventory_item_id;
	}
	public void setInventory_item_id(Long inventory_item_id) {
		this.inventory_item_id = inventory_item_id;
	}
	public int getInventory_quantity() {
		return inventory_quantity;
	}
	public void setInventory_quantity(int inventory_quantity) {
		this.inventory_quantity = inventory_quantity;
	}
	public int getOld_inventory_quantity() {
		return old_inventory_quantity;
	}
	public void setOld_inventory_quantity(int old_inventory_quantity) {
		this.old_inventory_quantity = old_inventory_quantity;
	}
	public String getRequires_shipping() {
		return requires_shipping;
	}
	public void setRequires_shipping(String requires_shipping) {
		this.requires_shipping = requires_shipping;
	}
	public String getAdmin_graphql_api_id() {
		return admin_graphql_api_id;
	}
	public void setAdmin_graphql_api_id(String admin_graphql_api_id) {
		this.admin_graphql_api_id = admin_graphql_api_id;
	}
	@Override
	public String toString() {
		return "Variants [id=" + id + ", product_id=" + product_id + ", title=" + title + ", price=" + price + ", sku="
				+ sku + ", position=" + position + ", inventory_policy=" + inventory_policy + ", compare_at_price="
				+ compare_at_price + ", fulfillment_service=" + fulfillment_service + ", inventory_management="
				+ inventory_management + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", taxable=" + taxable + ", barcode="
				+ barcode + ", grams=" + grams + ", image_id=" + image_id + ", weight=" + weight + ", weight_unit="
				+ weight_unit + ", inventory_item_id=" + inventory_item_id + ", inventory_quantity="
				+ inventory_quantity + ", old_inventory_quantity=" + old_inventory_quantity + ", requires_shipping="
				+ requires_shipping + ", admin_graphql_api_id=" + admin_graphql_api_id + "]";
	}
	
	
}
