package com.practice.onlinestore.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.onlinestore.orderservice.dto.OrderRequest;
import com.practice.onlinestore.orderservice.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/order")
public class orderController {
	
	@Autowired
	private OrderService orderService;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CircuitBreaker(name="inventorycb",fallbackMethod = "inventoryCbFallback")
	public String placedOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return  "Order Placed Successfully";
	}
	
	public String inventoryCbFallback(OrderRequest orderRequest, RuntimeException runtimeException) {
		return "oops!! Something went wrong, please place order after some time.....!!!!";
	}
}
