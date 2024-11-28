package com.khan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Transactional
	public void saveEmp(EmployeeEntity emp) {

		employeeRepo.saveEml(emp.getEmpId(), emp.getEmpName(), emp.getDept(), emp.getEmpSalary());
		System.out.println("Employee inserted successfully!");
	}
	
	@Transactional
    public void updateEmp(EmployeeEntity emp) {
        employeeRepo.updateEmp(emp.getEmpId(), emp.getEmpName(), emp.getDept(), emp.getEmpSalary());
        System.out.println("Employee updated successfully!");
    }

    @Transactional
    public void deleteEmpById(Integer id) {
        employeeRepo.deleteEmpById(id);
        System.out.println("Employee deleted successfully!");
    }
}
