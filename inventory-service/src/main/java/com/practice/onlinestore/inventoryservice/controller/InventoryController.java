package com.practice.onlinestore.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.onlinestore.inventoryservice.dto.InventoryResponse;
import com.practice.onlinestore.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	
	// http://localhost:8082/api/inventory?sku-code=iphone_13&sku-code=iphone_13_red
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		
		return inventoryService.isInStock(skuCode);
	}

}
