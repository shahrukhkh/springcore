package com.khan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khan.config.AppConfig;
import com.khan.service.Restaurent;

public class MyApp {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Restaurent bean = con.getBean("restaurent",Restaurent.class);
		System.out.println(bean);
		bean.payBill();
	}
}
