package com.practice.onlinestore.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.practice.onlinestore.orderservice.dto.InventoryResponse;
import com.practice.onlinestore.orderservice.dto.OrderLineItemsDto;
import com.practice.onlinestore.orderservice.dto.OrderRequest;
import com.practice.onlinestore.orderservice.event.OrderPlacedEvent;
import com.practice.onlinestore.orderservice.model.Order;
import com.practice.onlinestore.orderservice.model.OrderLineItems;
import com.practice.onlinestore.orderservice.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
	

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
	
		List<OrderLineItems> orderlineItem = orderRequest.orderLineItemsDtoList()
												.stream()
												.map(this::mapToDto)
												.toList();
		order.setorderLineItemsList(orderlineItem);
		
		List<String> skuCodes = order.getorderLineItemsList()
										.stream()
										.map(orderlineItems->orderlineItems.getSkuCode())
										.toList();
			
		
		// Call inventory service and place order if product is in stock
		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
						.uri("http://inventory-service/api/inventory",
								uriBuilder-> uriBuilder.queryParam("skuCode", skuCodes).build())
						.retrieve()
						.bodyToMono(InventoryResponse[].class)
						.block();
		
		boolean allProductInStock = Arrays
									.stream(inventoryResponseArray)
									.allMatch(inventoryResponse -> inventoryResponse.isInStock());
		
		if (allProductInStock) {
			orderRepository.save(order);
			kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
			
		}else {
			throw new IllegalArgumentException("product is not in Stock");
		}
		
		
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemDto.getPrice());
		orderLineItems.setQuentity(orderLineItemDto.getQuentity());
		orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
		
		return orderLineItems;
		
	}
}
