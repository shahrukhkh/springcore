package com.khan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	
	public static void main(String[] args) {
		ApplicationContext con=new ClassPathXmlApplicationContext("beans.xml");
		TargetClass bean = con.getBean("tobj",TargetClass.class);
		System.out.println(bean);
	}
}
