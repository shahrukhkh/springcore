package com.khan.app.restcontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.entity.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@GetMapping("/get")
	public ResponseEntity<User> getUser()
	{
		String[] cr= {"JAVA","AWS"};
		User user = new User(101, "Shahrukh Khan", "123@pass",List.of("Admin","QA") 
				,cr,Map.of("C1","T1","C2","T2") );
		
		return  new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
