package com.khan.app.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StrudentRestController {

	//1. fetch resource
	@GetMapping("/fetch")
	public ResponseEntity<String> getStudents()
	{
		ResponseEntity<String> res= new ResponseEntity<>("From GET Operation",HttpStatus.OK);
		return res;
	}
	//2. save resource
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent()
	{
		ResponseEntity<String> res= new ResponseEntity<>("From POST Operation",HttpStatus.OK);
		return res;
	}
	//3. update resource
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent()
	{
		ResponseEntity<String> res= new ResponseEntity<>("From PUT Operation",HttpStatus.OK);
		return res;
	}
	
	//4. remove resource
	@DeleteMapping("/remove")
	public ResponseEntity<String> removeStudent()
	{
		ResponseEntity<String> res= new ResponseEntity<>("From DELETE Operation",HttpStatus.OK);
		return res;
	}
	//5. partial update resource
	@PatchMapping("/updatename")
	public ResponseEntity<String> updateStudentName()
	{
		ResponseEntity<String> res= new ResponseEntity<>("From PATCH Operation",HttpStatus.OK);
		return res;
	}
	
}
