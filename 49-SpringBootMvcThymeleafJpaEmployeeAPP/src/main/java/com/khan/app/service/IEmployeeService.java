package com.khan.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.khan.app.entity.EmployeeEntity;
import com.khan.app.exception.EmployeeEntityNotFoundException;

public interface IEmployeeService {

	
	
	Integer saveEmployeeEntity(EmployeeEntity e);
	
	void updateEmployeeEntity(EmployeeEntity e);
	
	void deleteEmployeeEntity(Integer id)
			throws EmployeeEntityNotFoundException;
	
	EmployeeEntity getOneEmployeeEntity(Integer id)
			throws EmployeeEntityNotFoundException;
	
	List<EmployeeEntity> getAllEmployeeEntitys();
	
	Page<EmployeeEntity> getAllEmployeeEntitys(Pageable pageable);
}
