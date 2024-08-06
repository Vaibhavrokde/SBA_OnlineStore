package com.practice.onlinestore.notificationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.practice.onlinestore.notificationservice.events.OrderPlacedEvent;

@SpringBootApplication
public class NotificationServiceApplication {
	
	Logger logger = LoggerFactory.getLogger(NotificationServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	
	@KafkaListener(topics= "notificationTopic")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
		logger.info("recieved Notificaation for order - {}", orderPlacedEvent.getOrderNumber());
	}

}
