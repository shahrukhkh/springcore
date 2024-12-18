package com.khan.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khan.app.entity.StudentEntity;
import com.khan.app.exception.StudentNotFoundException;
import com.khan.app.repo.StudentRepo;
import com.khan.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepo studentRepo;
	
	public StudentServiceImpl(StudentRepo studentRepo)
	{
		this.studentRepo=studentRepo;
	}

	@Override
	public Integer saveStudent(StudentEntity s) {

		return studentRepo.save(s).getStdId();

	}

	@Override
	public void updateStudent(StudentEntity s) {

		if (s.getStdId() == null || !studentRepo.existsById(s.getStdId())) {
			throw new StudentNotFoundException("STUDENT '" + s.getStdId() + "' NOT FOUND");
		}
		else
			studentRepo.save(s);
	}

	@Override
	public void removeStudentById(Integer id) {

		studentRepo.delete(getOneStudent(id));
	}

	@Override
	public StudentEntity getOneStudent(Integer id) {
		return studentRepo.findById(id)
						  .orElseThrow(
							()-> 
							new StudentNotFoundException("STUDENT '"+id+"' NOT FOUND"));
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		return studentRepo.findAll();
	}

}
