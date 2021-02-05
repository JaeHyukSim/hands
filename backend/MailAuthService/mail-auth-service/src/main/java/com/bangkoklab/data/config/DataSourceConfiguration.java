package com.bangkoklab.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySources({
		@PropertySource(value = "file:C:/project1/project1-resources/properties/test-config.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:${user.home}/env/test-config.properties", ignoreResourceNotFound = true) })
@Setter @Getter
public class DataSourceConfiguration {
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${mail.id}")
	private String mailId;
	@Value("${mail.secret}")
	private String mailSecret;
	

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public DataSourceConfiguration() {
		super();
		System.out.println("생성됨 : " + driverClassName);
		
	}

	
}
