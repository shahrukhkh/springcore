package com.khan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
		Parent bean = ctxt.getBean(Parent.class);
		System.out.println(bean);
		System.out.println(bean.getChild().hashCode());
		Parent bean2 = ctxt.getBean(Parent.class);
		System.out.println(bean2);
		System.out.println(bean2.getChild().hashCode());

		Parent bean3 = ctxt.getBean(Parent.class);
		System.out.println(bean3);
		System.out.println(bean3.getChild().hashCode());

		Parent bean4 = ctxt.getBean(Parent.class);
		System.out.println(bean4);
		System.out.println(bean4.getChild().hashCode());

	}
}
