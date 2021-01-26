package com.bangkoklab.findHandService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bangkoklab.findHandService.data.mapper")
public class FindHandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindHandServiceApplication.class, args);
	}

}
