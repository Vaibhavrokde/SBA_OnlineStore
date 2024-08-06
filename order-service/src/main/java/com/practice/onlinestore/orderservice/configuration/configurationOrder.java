package com.practice.onlinestore.orderservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configurationOrder {
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}


}
