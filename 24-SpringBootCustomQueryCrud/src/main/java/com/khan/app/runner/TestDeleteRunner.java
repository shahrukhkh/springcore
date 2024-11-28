package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.khan.app.service.EmployeeService;
@Component
@Order(20)
public class TestDeleteRunner implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	@Override
	public void run(String... args) throws Exception {

		employeeService.deleteEmpById(1001);
	}

}
