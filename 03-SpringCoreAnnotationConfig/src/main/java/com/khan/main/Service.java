package com.khan.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("sobj")
public class Service {
	public Service()
	{
		System.out.println("Service.Service()");
	}

	@Value("Shahrukh")
	private String ename;
	@Value("1983921")
	private int eid;
	@Override
	public String toString() {
		return "Service [ename=" + ename + ", eid=" + eid + "]";
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
}
