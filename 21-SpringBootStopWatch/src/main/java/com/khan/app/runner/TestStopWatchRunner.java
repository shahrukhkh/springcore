package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.service.AppWatcher;
@Component
public class TestStopWatchRunner implements CommandLineRunner{

	@Autowired
	private AppWatcher appWatcher;
	@Override
	public void run(String... args) throws Exception {
		
		appWatcher.watch();
		
	}

}
