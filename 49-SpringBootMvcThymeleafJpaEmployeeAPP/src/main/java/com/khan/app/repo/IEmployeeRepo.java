package com.khan.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.EmployeeEntity;

public interface IEmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
