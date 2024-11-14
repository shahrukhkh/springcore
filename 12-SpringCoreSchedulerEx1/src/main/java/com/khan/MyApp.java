package com.khan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
