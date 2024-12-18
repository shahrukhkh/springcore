package com.khan.app.service;

import java.util.List;

import com.khan.app.entity.StudentEntity;

public interface StudentService {

	Integer saveStudent(StudentEntity s);
	void updateStudent(StudentEntity s);
	void removeStudentById(Integer id);
	StudentEntity getOneStudent(Integer id);
	List<StudentEntity> getAllStudent();
}
