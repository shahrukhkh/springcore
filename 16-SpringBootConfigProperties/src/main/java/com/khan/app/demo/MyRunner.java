package com.khan.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private Employee emp;

	@Override
	public void run(String... args) throws Exception {

		System.out.println(emp);
	}

}
