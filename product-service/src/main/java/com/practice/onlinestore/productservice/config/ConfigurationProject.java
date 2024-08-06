package com.practice.onlinestore.productservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationProject {
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

}
