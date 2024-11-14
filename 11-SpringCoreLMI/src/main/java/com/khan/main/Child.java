package com.khan.main;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Child {

	
	private int otp;
	
	public Child() {
		
		System.out.println("Child.Child()");
		otp=Math.abs(new Random().nextInt());
	}

	public int getOtp() {
		return otp;
	}
	

	@Override
	public String toString() {
		return "Child [otp=" + otp + "]";
	}
	
	
			
}
