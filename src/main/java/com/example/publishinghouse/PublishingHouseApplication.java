package com.example.publishinghouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublishingHouseApplication {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		SpringApplication.run(PublishingHouseApplication.class, args);
	}

}
