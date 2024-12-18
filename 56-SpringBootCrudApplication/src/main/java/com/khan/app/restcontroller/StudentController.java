package com.khan.app.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.entity.StudentEntity;
import com.khan.app.exception.StudentNotFoundException;
import com.khan.app.service.StudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/v1/api/student")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {

		this.studentService=studentService;
	}
	@PostMapping("/create")
	public ResponseEntity<String>  createStudent(@RequestBody @Valid StudentEntity student)
	{
		student.setStdId(null);
		Integer id = studentService.saveStudent(student);
		String message="STUDENT '"+id+"' IS CREATED...";
		
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<StudentEntity>> fetchAllStudent()
	{
		List<StudentEntity> allStudent = studentService.getAllStudent();
		return ResponseEntity.ok(allStudent);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<StudentEntity> getOneStudent(@PathVariable("id") Integer id)
	{
		ResponseEntity<StudentEntity> res=null;
		
		try {
			StudentEntity oneStudent = studentService.getOneStudent(id);
			res=ResponseEntity.ok(oneStudent);
		}
		catch(StudentNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteOneStudent(@PathVariable("id") Integer id)
	{
		ResponseEntity<String> res=null;
		
		try {
			studentService.removeStudentById(id);
			res=ResponseEntity.ok("STUDENT '"+id+"' IS DELETED...");
		}
		catch(StudentNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentEntity  s)
	{
		ResponseEntity<String> res=null;
		
		try {
			studentService.updateStudent(s);
			res=ResponseEntity.ok("STUDENT '"+s.getStdId()+"' IS UPDATED...");
		}
		catch(StudentNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}

}
