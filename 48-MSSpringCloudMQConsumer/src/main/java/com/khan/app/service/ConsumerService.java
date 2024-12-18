package com.khan.app.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	
	@JmsListener(destination = "${my.app.desti-name}")
	public void readMsg(String msg)
	{
		System.out.println(msg);
	}
}
