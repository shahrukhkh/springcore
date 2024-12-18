package com.khan.app.customexception;

public class ProductNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String msg) {
		super(msg);
	}
	
}
