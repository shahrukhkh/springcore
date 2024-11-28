package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.db.Mydb;

@Component
public class MyRunner implements CommandLineRunner{

	@Autowired
	private Mydb db;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(db);
		
	}

}
