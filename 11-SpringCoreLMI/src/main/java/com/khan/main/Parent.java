package com.khan.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Parent {
	@Autowired
	private Child child;
	
	public Parent() {
		System.out.println("Parent.Parent()");
	}

	@Lookup
	public Child getOTPLMI() {
		
		return null;
	}

	@Override
	public String toString() {
		return "Parent [child=" + child + "]";
	}



	public Child getChild() {
		child=getOTPLMI();
		return child;
	}
	
	

}
