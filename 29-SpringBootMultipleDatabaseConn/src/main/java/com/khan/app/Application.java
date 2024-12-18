package com.khan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.khan.app.mysql.entity.Product;
import com.khan.app.mysql.entity.Product.ProductBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
		
	}

}
