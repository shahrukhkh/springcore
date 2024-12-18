package com.khan.app.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.khan.app.entity.ProductEntity;
import com.khan.app.repo.ProductCrudRepo;
@Component
@Order(1)
public class TestSaveDummyData implements CommandLineRunner {

	@Autowired
	private ProductCrudRepo productRepoCrud;
	@Override
	public void run(String... args) throws Exception {

		
		ProductEntity product1 = new ProductEntity(1, "Product1", 10.0);
		ProductEntity product2 = new ProductEntity(2, "Product2", 20.0);
		ProductEntity product3 = new ProductEntity(3, "Product3", 30.0);
		ProductEntity product4 = new ProductEntity(4, "Product4", 40.0);
		ProductEntity product5 = new ProductEntity(5, "Product5", 50.0);
		ProductEntity product6 = new ProductEntity(6, "Product6", 60.0);
		ProductEntity product7 = new ProductEntity(7, "Product7", 70.0);
		ProductEntity product8 = new ProductEntity(8, "Product8", 80.0);
		ProductEntity product9 = new ProductEntity(9, "Product9", 90.0);
		ProductEntity product10 = new ProductEntity(10, "Product10", 100.0);

		productRepoCrud.saveAll(Arrays
				.asList(product1,product2,product3,product4,
						product5,product6,product7,product8,product9,product10));
	}

}
