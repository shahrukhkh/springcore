package com.khan.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.Product;
import com.khan.app.repo.ProductRepo;
@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;
	@Override
	public void run(String... args) throws Exception {

		 Product p1 = new Product(1001, "Samsung TV", 1992.12);
	        Product p2 = new Product(1002, "Apple iPhone", 1299.99);
	        Product p3 = new Product(1003, "Sony Headphones", 299.99);
	        Product p4 = new Product(1004, "Dell Laptop", 999.99);
	        Product p5 = new Product(1005, "HP Printer", 199.49);
	        Product p6 = new Product(1006, "LG Monitor", 249.99);
	        Product p7 = new Product(1007, "Google Pixel", 899.99);
	        Product p8 = new Product(1008, "Amazon Echo", 79.99);
	        Product p9 = new Product(1009, "Bose Speaker", 499.99);
	        Product p10 = new Product(1010, "Canon Camera", 649.99);
	        Product p11 = new Product(1011, "Xbox Console", 499.99);
	        Product p12 = new Product(1012, "PlayStation Console", 549.99);
	        Product p13 = new Product(1013, "Samsung Refrigerator", 1999.99);
	        Product p14 = new Product(1014, "Sony Soundbar", 299.99);
	        Product p15 = new Product(1015, "Apple Watch", 399.99);
	        Product p16 = new Product(1016, "Fitbit Tracker", 129.99);
	        Product p17 = new Product(1017, "Nikon Camera", 749.99);
	        Product p18 = new Product(1018, "GoPro Camera", 349.99);
	        Product p19 = new Product(1019, "Microsoft Surface", 1199.99);
	        Product p20 = new Product(1020, "Lenovo Tablet", 299.99);

		productRepo.saveAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,
							p13,p14,p15,p16,p17,p18,p19,p20));
		
		productRepo.findByNameAndPrice("Samsung TV", 1992.12).ifPresentOrElse(e->System.out.println(e), ()->System.out.println("Product Not Found..."));
		productRepo.findByNameOrPrice("Samsung", 1992.12).forEach(System.out::println);
		productRepo.findByPriceBetween(1002.0, 5000.0).forEach(System.out::println);
		productRepo.findByPriceLessThan(1992.12).forEach(System.out::println);
		productRepo.findByPriceLessThanEqual(1992.12).forEach(System.out::println);
		productRepo.findByPriceGreaterThan(1992.12).forEach(System.out::println);
		productRepo.findByPriceGreaterThanEqual(1992.12).forEach(System.out::println);
		productRepo.findByPriceAfter(499.99).forEach(System.out::println);
		productRepo.findByPriceBefore(499.99).forEach(System.out::println);
		productRepo.findByPriceIsNull().forEach(System.out::println);
		productRepo.findByPriceNotNull().forEach(System.out::println);
		productRepo.findByNameLike("__s").forEach(System.out::println);
		productRepo.findByNameNotLike("S__").forEach(System.out::println);
		productRepo.findByNameStartingWith("S").forEach(System.out::println);
		productRepo.findByNameEndingWith("L").forEach(System.out::println);
		productRepo.findByNameContaining("%sun%").forEach(System.out::println);
		productRepo.findByOrderByPriceDesc().forEach(System.out::println);
		productRepo.findByNameNot("Sony Soundbar").forEach(System.out::println);
		productRepo.findByPriceIn(List.of(199.49,129.99,1992.12)).forEach(System.out::println);
		productRepo.findByPriceNotIn(List.of(199.49,129.99,1992.12)).forEach(System.out::println);
		productRepo.findByNameIgnoreCase("hp printer").forEach(System.out::println);
		
	}

}
