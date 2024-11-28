package com.khan.app.db;

import lombok.Data;

@Data
public class Mydb {
	
	private String dbname="oracle";
	public Mydb() {
		System.out.println("Mydb.Mydb()");
	}
}
