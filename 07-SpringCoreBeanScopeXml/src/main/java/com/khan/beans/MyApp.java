package com.khan.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	
	public static void main(String[] args) {
		
		
		ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		
		MyService bean = con.getBean("mySer",MyService.class);
		MyService bean2 = con.getBean("mySer1",MyService.class);
		System.out.println(bean.hashCode());
		System.out.println(bean2.hashCode());
	}
}
