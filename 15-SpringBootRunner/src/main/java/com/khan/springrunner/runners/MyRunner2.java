package com.khan.springrunner.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class MyRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("MyRunner2.run() order is 2");

	}

}
