package com.khan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext con= new AnnotationConfigApplicationContext();
		con.scan("com.khan");
		con.refresh();
		Service bean = con.getBean("sobj",Service.class);
		System.out.println(bean);
	}
}
