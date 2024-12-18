package com.khan.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.khan.app.entity.StudentEntity;

public interface StudentRepo extends PagingAndSortingRepository<StudentEntity, Integer> {

}
