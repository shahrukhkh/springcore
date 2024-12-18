package com.khan;

public class TargetClass {

	
	private int tid;
	private String tname;
	private DependentClass dc;
	
	public TargetClass() {
		System.out.println("TargetClass.TargetClass()");
	}

	@Override
	public String toString() {
		return "TargetClass [tid=" + tid + ", tname=" + tname + ", dc=" + dc 
				+ "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public DependentClass getDc() {
		return dc;
	}

	public void setDc(DependentClass dc) {
		this.dc = dc;
	}
	
}
