package com.khan.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.service.MyService;

public class MyApp {

	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");
		MyService bean = ctxt.getBean("m1",MyService.class);
		bean.running();
		ctxt.close();
	}
}
