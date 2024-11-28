package com.khan.app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication run = new SpringApplication(Application.class);
		//run.setBannerMode(Mode.OFF);
		run.run(args);
		System.out.println("started...");
	}

}
