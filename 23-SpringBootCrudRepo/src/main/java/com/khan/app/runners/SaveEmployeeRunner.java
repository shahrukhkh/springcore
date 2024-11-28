package com.khan.app.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.repo.EmployeeRepo;
@Component
public class SaveEmployeeRunner implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public void run(String... args) throws Exception {
		
		
		
		EmployeeEntity savedEmp = employeeRepo.save(new EmployeeEntity(10,"Shahrukh Khan",1001,"Java Developer"));
		System.out.println(savedEmp);
		
	}

}
