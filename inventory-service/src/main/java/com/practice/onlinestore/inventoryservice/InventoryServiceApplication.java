package com.practice.onlinestore.inventoryservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.onlinestore.inventoryservice.model.Inventory;
import com.practice.onlinestore.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner loadData(InventoryRepository invetoryRepository) {
		return args->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuentity(100);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuentity(0);
			
			invetoryRepository.save(inventory);
			invetoryRepository.save(inventory1);
			
		};
	}
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

}
