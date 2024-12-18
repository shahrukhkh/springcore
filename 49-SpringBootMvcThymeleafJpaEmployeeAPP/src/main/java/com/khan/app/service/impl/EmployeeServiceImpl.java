package com.khan.app.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.exception.EmployeeEntityNotFoundException;
import com.khan.app.repo.IEmployeeRepo;
import com.khan.app.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	private IEmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(IEmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}

	@Override
	public Integer saveEmployeeEntity(EmployeeEntity e) {
		Double hra=e.getEmpSal()*(12.0/100);
		e.setEmpHra(hra);
		Double ta=e.getEmpSal()*(4.0/100);
		e.setEmpTa(ta);
		EmployeeEntity savedEmp = employeeRepo.save(e);
		return savedEmp.getEmpId();
	}

	@Override
	public void updateEmployeeEntity(EmployeeEntity e) {
		Double hra=e.getEmpSal()*(12.0/100);
		e.setEmpHra(hra);
		Double ta=e.getEmpSal()*(4.0/100);
		e.setEmpTa(ta);
		employeeRepo.save(e);
	}

	@Override
	public void deleteEmployeeEntity(Integer id) throws EmployeeEntityNotFoundException {
		employeeRepo.delete(this.getOneEmployeeEntity(id));
	}

	@Override
	public EmployeeEntity getOneEmployeeEntity(Integer id) throws EmployeeEntityNotFoundException {
		return employeeRepo.findById(id).orElseThrow(()-> new EmployeeEntityNotFoundException("Employee '"+id+"' not found"));
	}

	@Override
	public List<EmployeeEntity> getAllEmployeeEntitys() {
		return employeeRepo.findAll();
	}

	@Override
	public Page<EmployeeEntity> getAllEmployeeEntitys(Pageable pageable) {
		return employeeRepo.findAll(pageable);
	}

}
