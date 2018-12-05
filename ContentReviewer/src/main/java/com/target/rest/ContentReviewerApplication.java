package com.target.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.target"})
public class ContentReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentReviewerApplication.class, args);
	}
	
	
	
}
