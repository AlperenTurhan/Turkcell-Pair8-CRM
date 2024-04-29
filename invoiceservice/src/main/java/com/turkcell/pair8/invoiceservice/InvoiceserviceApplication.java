package com.turkcell.pair8.invoiceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class InvoiceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceserviceApplication.class, args);
	}

	@KafkaListener(topics = "orderTopic", groupId = "invoiceGroup")
	public void handleEvent(String message){
		System.out.println("Kafka message received: "+ message);
	}
}
