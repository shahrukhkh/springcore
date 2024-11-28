package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.db.DB;
@Component
public class TestDBRunner implements CommandLineRunner {

	@Autowired
	private DB db;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(db);

	}

}
