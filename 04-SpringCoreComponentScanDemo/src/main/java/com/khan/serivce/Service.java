package com.khan.serivce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sobj")
public class Service {

	@Value("Shahrukh")
	private String ename;
	@Value("276")
	private int id;
	
	public Service()
	{
		System.out.println("Service.Service()");
	}

	@Override
	public String toString() {
		return "Service [ename=" + ename + ", id=" + id + "]";
	}
}
