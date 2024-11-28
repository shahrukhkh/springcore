package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.service.MyDuration;
@Component
public class TestDurationRunner implements CommandLineRunner{

	@Autowired
	private MyDuration myDuration;
	@Override
	public void run(String... args) throws Exception {
		myDuration.timeTaken();
		
	}

}
