package com.khan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khan.config.AppConfig;
import com.khan.serivce.Service;

public class MyApp {

	
	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Service bean = con.getBean("sobj",Service.class);
		System.out.println(bean);
	}
}
