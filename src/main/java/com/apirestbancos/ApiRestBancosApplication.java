package com.apirestbancos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"com.apirestbancos.model"})
@ComponentScan(basePackages = {"com.*"})
public class ApiRestBancosApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ApiRestBancosApplication.class, args);
	}

}
