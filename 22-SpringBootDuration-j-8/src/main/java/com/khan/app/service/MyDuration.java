package com.khan.app.service;

import java.time.Duration;

import org.springframework.stereotype.Component;
@Component
public class MyDuration {

	
	
	public void timeTaken()
	{
		long startTime = System.nanoTime();
		for(long i=0; i<9999999999L; i++)
		{
			
		}
		Duration timeTaken= Duration.ofNanos(System.nanoTime()-startTime);
		
		System.out.println(timeTaken.getSeconds());
		System.out.println(timeTaken.getNano());
		System.out.println(timeTaken.negated());
		
	}
}
