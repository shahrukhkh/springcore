package com.khan.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.khan")
public class AppConfig {

	
	public AppConfig()
	{
		System.out.println("AppConfig.AppConfig()");
	}
}
