package com.khan.beans;

public class MyService {

	
	private MyRepo myRepo;
	
	public MyService() {
		System.out.println("MyService.MyService() || CONSTRUCTOR");
	}

	public MyRepo getMyRepo() {
		return myRepo;
	}

	public void setMyRepo(MyRepo myRepo) {
		this.myRepo = myRepo;
	}
	
	
}
