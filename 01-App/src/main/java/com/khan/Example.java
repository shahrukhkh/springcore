package com.khan;

public class Example {

	
	Example()
	{
		System.out.println("Example.Example() 0-param");
	}
	
	private int id;
	private String name;
	private Sample sample;
	
	public void PrintMsg()
	{
		System.out.println("Example.PrintMsg() || Hii");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", name=" + name + ", sample=" + sample + "]";
	}
	
}
