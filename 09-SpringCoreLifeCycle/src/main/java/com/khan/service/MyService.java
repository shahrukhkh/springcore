package com.khan.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyService implements DisposableBean, InitializingBean {
	
	public MyService() {
		System.out.println("MyService.MyService()");
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("MyService.afterPropertiesSet()");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("MyService.destroy()");

	}
	
	public void m1()
	{
		System.out.println("MyService.m1()");
	}

}
