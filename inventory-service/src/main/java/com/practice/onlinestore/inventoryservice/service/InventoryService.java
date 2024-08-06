package com.practice.onlinestore.inventoryservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.onlinestore.inventoryservice.dto.InventoryResponse;
import com.practice.onlinestore.inventoryservice.model.Inventory;
import com.practice.onlinestore.inventoryservice.repository.InventoryRepository;


@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		
		return inventoryRepository.findBySkuCodeIn(skuCode)
				.stream().map(inventory -> mapToInventoryResponse(inventory)).toList();
	}

	private InventoryResponse mapToInventoryResponse(Inventory inventory) {
		InventoryResponse inventoryresponse= modelMapper.map(inventory, InventoryResponse.class);
		inventoryresponse.setInStock(inventory.getQuentity() > 0);
		return inventoryresponse;
		
	}

}
