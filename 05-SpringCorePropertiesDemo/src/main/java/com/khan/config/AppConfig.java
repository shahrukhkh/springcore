package com.khan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.khan")
@PropertySource("classpath:app.properties")
public class AppConfig {

	
	public AppConfig()
	{
		System.out.println("AppConfig.Service()");
	}
}
