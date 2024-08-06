package com.practice.onlinestore.orderservice.dto;

import java.math.BigDecimal;

public class OrderLineItemsDto {
	
private Long id;
	
	private String skuCode;
	private BigDecimal price;
	private Integer quentity;
	public OrderLineItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLineItemsDto(Long id, String skuCode, BigDecimal price, Integer quentity) {
		super();
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quentity = quentity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuentity() {
		return quentity;
	}
	public void setQuentity(Integer quentity) {
		this.quentity = quentity;
	}

}
