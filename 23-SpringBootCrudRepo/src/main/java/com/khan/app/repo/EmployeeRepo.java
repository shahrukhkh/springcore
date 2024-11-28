package com.khan.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.khan.app.entity.EmployeeEntity;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer>{

}
