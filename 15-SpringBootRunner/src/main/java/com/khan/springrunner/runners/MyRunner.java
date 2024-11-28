package com.khan.springrunner.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("My Runner is executed...");

	}

}
