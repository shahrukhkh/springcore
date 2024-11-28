package com.khan.springrunner.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(3)
public class MyRunner3 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("MyRunner3.run() order is 3");

	}

}
