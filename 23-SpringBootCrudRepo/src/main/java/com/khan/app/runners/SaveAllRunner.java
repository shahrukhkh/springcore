package com.khan.app.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.repo.EmployeeRepo;
@Component
public class SaveAllRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {
		
		employeeRepo.saveAll(Arrays.asList(
				new EmployeeEntity(1001, "Farhan", 102, "Developer"),
				new EmployeeEntity(1002, "Shah", 102, "Manager"),
				new EmployeeEntity(1003, "Khan", 103, "Intern Developer"),
				new EmployeeEntity(1004, "Faisal", 104, "Junior Developer"),
				new EmployeeEntity(1005, "Manish", 105, "Senior Developer")));
	}

}
