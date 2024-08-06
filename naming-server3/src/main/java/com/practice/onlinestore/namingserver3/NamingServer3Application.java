package com.practice.onlinestore.namingserver3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServer3Application {

	public static void main(String[] args) {
		SpringApplication.run(NamingServer3Application.class, args);
	}

}
