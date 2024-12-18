package com.khan.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

}
