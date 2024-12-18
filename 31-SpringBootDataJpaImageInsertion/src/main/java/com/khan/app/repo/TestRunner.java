package com.khan.app.repo;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.Product;
@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;
	@Override
	public void run(String... args) throws Exception {
		
		File f1 = new File("C:\\Users\\khans\\OneDrive\\Desktop\\img\\iphone.jpeg");
		
		byte byteI[] = new byte[(int) f1.length()];
		FileInputStream fis = new FileInputStream(f1);
		fis.read(byteI);
		Product p1=new Product(101, "Iphone", byteI, null, null);

		productRepo.save(p1);
	}

}
