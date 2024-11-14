package com.khan.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.service.FileLoaderService;

public class MyApp {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cont= new ClassPathXmlApplicationContext("beans.xml");
		FileLoaderService bean = cont.getBean(FileLoaderService.class);
		bean.loadDataFromFile("C:\\Users\\khans\\OneDrive\\Desktop\\books.txt");
		
		bean.generateExcelForBooks("C:\\Users\\khans\\OneDrive\\Desktop\\Books2.xlsx");
		cont.close();
	}
}
