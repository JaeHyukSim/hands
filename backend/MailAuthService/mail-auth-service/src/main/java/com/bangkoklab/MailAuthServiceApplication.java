package com.bangkoklab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MailAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailAuthServiceApplication.class, args);
	}
}