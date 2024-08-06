package com.practice.onlinestore.notificationservice.events;

public class OrderPlacedEvent {	
	private String orderNumber;
	public OrderPlacedEvent() {
		super();
	}

	public OrderPlacedEvent(String orderNumber) {
		super();
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	

}
