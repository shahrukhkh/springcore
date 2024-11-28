package com.khan.app.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component
public class AppWatcher {

	
	public void watch()
	{
		
		StopWatch sw=new StopWatch();
		
		sw.start();
		for(int i=0; i<Integer.MAX_VALUE; i++)
		{
			Math.pow(i, i+1);
		}
		sw.stop();
		
		System.out.println(sw.getTotalTimeSeconds());
		System.out.println(sw.getTotalTimeMillis());
	}
}
