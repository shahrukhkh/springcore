package com.khan.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.service.FileLoaderService;

public class MyApp {

	
	public static void main(String[] args) {
		ApplicationContext cont= new ClassPathXmlApplicationContext("beans.xml");
		FileLoaderService bean = cont.getBean(FileLoaderService.class);
		
		bean.loadDataFromFile("C:\\Users\\khans\\OneDrive\\Desktop\\books.txt");
	}
}
