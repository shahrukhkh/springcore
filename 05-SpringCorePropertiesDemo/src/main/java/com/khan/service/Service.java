package com.khan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sobj")
public class Service {

	@Value("${db.name}")
	private String dbName;
	@Value("${db-url}")
	private String dbURL;
	@Value("${db_username}")
	private String username;
	@Value("${db.pwzz}")
	private String password;
	@Value("${db.con.max}")
	private int noOfConnection;
	@Override
	public String toString() {
		return "Service [dbName=" + dbName + ", dbURL=" + dbURL + ", username=" + username + ", password=" + password
				+ ", noOfConnection=" + noOfConnection + "]";
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNoOfConnection() {
		return noOfConnection;
	}
	public void setNoOfConnection(int noOfConnection) {
		this.noOfConnection = noOfConnection;
	}
	
	public Service()
	{
		System.out.println("Service.Service()");
	}
}
