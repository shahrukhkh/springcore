package com.khan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext contxt=new ClassPathXmlApplicationContext("beans.xml");
		Example bean =(Example) contxt.getBean("obj");
		bean.PrintMsg();
		System.out.println(bean);
	
	}
}
