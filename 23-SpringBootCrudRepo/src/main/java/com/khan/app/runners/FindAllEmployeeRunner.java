package com.khan.app.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.repo.EmployeeRepo;
@Component
public class FindAllEmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public void run(String... args) throws Exception {

		employeeRepo.findAll().forEach(System.out::println);
	}

}
