package com.reactive.mongodb.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
public class Product {
	
	private Product() {
		super();
	}
	
	public Product(long id, String productName, Integer price, String productDesc) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.productDesc = productDesc;
	}

	@Id
	private long id;
	private String productName;
	private long price;
	private String productDesc;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	
}
