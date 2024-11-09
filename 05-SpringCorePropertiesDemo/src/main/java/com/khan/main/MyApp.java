package com.khan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khan.config.AppConfig;
import com.khan.service.Service;

public class MyApp {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Service bean = con.getBean("sobj",Service.class);
		System.out.println(bean);
	}
}
