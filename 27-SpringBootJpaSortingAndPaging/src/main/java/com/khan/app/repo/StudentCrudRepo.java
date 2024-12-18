package com.khan.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.khan.app.entity.StudentEntity;

public interface StudentCrudRepo extends CrudRepository<StudentEntity, Integer> {

}
