package com.khan.app.entity;

import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String ename;
	private Double sal;

	private Address adds;
	@JacksonXmlElementWrapper(localName = "langs")
	@JacksonXmlProperty(localName = "lang")
	private String[] lang;
	private Map<String, Integer> phno;
}
