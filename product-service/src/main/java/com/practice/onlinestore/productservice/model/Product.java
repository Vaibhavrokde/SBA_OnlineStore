package com.practice.onlinestore.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(value="product")
public class Product {
	
	@Id
	private String Id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, String description, BigDecimal price) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
