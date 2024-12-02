package com.khan.app.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.khan.app.repo.StudentCrudRepo;
import com.khan.app.repo.StudentRepo;
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private StudentCrudRepo crudRepo;
	@Autowired
	private StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> students = new ArrayList<>();

        students.add(new StudentEntity(1, "Alice", "Computer Science"));
        students.add(new StudentEntity(2, "Bob", "Mechanical Engineering"));
        students.add(new StudentEntity(3, "Charlie", "Electrical Engineering"));
        students.add(new StudentEntity(4, "David", "Civil Engineering"));
        students.add(new StudentEntity(5, "Eva", "Biotechnology"));
        students.add(new StudentEntity(6, "Frank", "Information Technology"));
        students.add(new StudentEntity(7, "Grace", "Electronics and Communication"));
        students.add(new StudentEntity(8, "Hank", "Aeronautical Engineering"));
        students.add(new StudentEntity(9, "Ivy", "Chemical Engineering"));
        students.add(new StudentEntity(10, "Jack", "Architecture"));
        students.add(new StudentEntity(11, "Kathy", "Physics"));
        students.add(new StudentEntity(12, "Liam", "Mathematics"));
        students.add(new StudentEntity(13, "Mia", "Philosophy"));
        students.add(new StudentEntity(14, "Noah", "Political Science"));
        students.add(new StudentEntity(15, "Olivia", "History"));
        students.add(new StudentEntity(16, "Paul", "Economics"));
        students.add(new StudentEntity(17, "Quinn", "Sociology"));
        students.add(new StudentEntity(18, "Rachel", "Psychology"));
        students.add(new StudentEntity(19, "Sam", "Literature"));
        students.add(new StudentEntity(20, "Tina", "Environmental Science"));

        
		crudRepo.saveAll(students);
		
		
		Sort by = Sort.by(Direction.ASC,"name");
		PageRequest of = PageRequest.of(0, 4,by);
		Page<StudentEntity> all = studentRepo.findAll(of);
		all.getContent().forEach(System.out::println);

		
	}

}
