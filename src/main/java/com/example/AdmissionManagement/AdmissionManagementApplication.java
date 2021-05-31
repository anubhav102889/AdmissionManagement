package com.example.AdmissionManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = { @PropertySource(value = { "classpath:mycustom.properties" }) })
public class AdmissionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionManagementApplication.class, args);
	}

}
