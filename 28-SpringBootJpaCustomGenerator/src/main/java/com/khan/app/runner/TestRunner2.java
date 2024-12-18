package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.Product;
import com.khan.app.repo.ProductRepo;
@Component
public class TestRunner2 implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	@Override
	public void run(String... args) throws Exception {

		productRepo.save(new Product());
	}

}
