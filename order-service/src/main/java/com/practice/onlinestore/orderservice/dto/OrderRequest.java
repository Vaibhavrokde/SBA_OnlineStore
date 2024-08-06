package com.practice.onlinestore.orderservice.dto;

import java.util.List;

public class OrderRequest {
	
	private List<OrderLineItemsDto> orderLineItemsDtoList;

	
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
		super();
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	public List<OrderLineItemsDto> orderLineItemsDtoList() {
		return orderLineItemsDtoList;
	}

	public void setOrderLineItemsDto(List<OrderLineItemsDto> orderLineItemsDtoList) {
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}
	

}
