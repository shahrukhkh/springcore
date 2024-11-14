package com.khan;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class MyService {
	public MyService() {
		System.out.println("constructor");
	}

	@Scheduled(fixedDelay = 2000)
	public void msg()
	{
		System.out.println("HELLO "+ new Date());
	}
}
